import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class BFS_Perfect_Squares{
    public int numSquares(int n){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(0);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int sumSoFar = queue.poll();
                for(int j = 1; j * j <= n; j++){
                    int sum = sumSoFar + j * j;
                    if(sum == n) return level;
                    if(sum > n) break;
                    if(!visited.contains(sum)){
                        queue.offer(sum);
                        visited.add(sum);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}