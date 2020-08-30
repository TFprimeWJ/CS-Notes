import java.lang.String;
import java.util.LinkedList;
import java.util.Queue;

class BFS_Java_Solution{
    public int openLock(String[] deadends, String target){
        // Initiate deadendSet
        boolean[] deadendSet = new boolean[10000];
        // Set the given deadends to be true
        for(String deadend : deadends){
            deadendSet[Integer.parseInt(deadend)] = true;
        }
        // Check if "0000" is a deadend, if true, return -1
        if(deadendSet[0]){
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[10000];
        visited[0] = true;
        int len = -1;
        int targetInt = Integer.parseInt(target);
        while(!queue.isEmpty()){
            ++len;
            final int size = queue.size();
            for(int i = 0; i < size; i++){
                final Integer node = queue.poll();
                if(node == targetInt){
                    return len;
                }
                final int[] nexts = getNexts(node);
                for(int next : nexts){
                    if(deadendSet[next]){
                        continue;
                    }
                    if(visited[next]){
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    // Calculate the next possible choice
    private int[] getNexts(int node){
        int b1 = node % 10;
        int b2 = node / 10 % 10;
        int b3 = node / 100 % 10;
        int b4 = node / 1000 % 10;
        int[] nextB1 = new int[]{(b1 + 11) % 10, (b1 + 9) % 10};
        int[] nextB2 = new int[]{(b2 + 11) % 10, (b2 + 9) % 10};
        int[] nextB3 = new int[]{(b3 + 11) % 10, (b3 + 9) % 10};
        int[] nextB4 = new int[]{(b4 + 11) % 10, (b4 + 9) % 10};
        int[] res = new int[8];
        int len = 0;
        res[len++] = b4 * 1000 + b3 * 100 + b2 * 10 + nextB1[0];
        res[len++] = b4 * 1000 + b3 * 100 + b2 * 10 + nextB1[1];
        res[len++] = b4 * 1000 + b3 * 100 + nextB2[0] * 10 + b1;
        res[len++] = b4 * 1000 + b3 * 100 + nextB2[1] * 10 + b1;
        res[len++] = b4 * 1000 + nextB3[0] * 100 + b2 * 10 + b1;
        res[len++] = b4 * 1000 + nextB3[1] * 100 + b2 * 10 + b1;
        res[len++] = nextB4[0] * 1000 + b3 * 100 + b2 * 10 + b1;
        res[len++] = nextB4[1] * 1000 + b3 * 100 + b2 * 10 + b1;
        return res;
    }
}