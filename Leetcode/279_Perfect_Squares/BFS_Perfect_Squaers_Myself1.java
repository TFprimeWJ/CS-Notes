import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class BFS_Perfect_Squares_Myself1{
    public int numSquares(int n){
        // Define Queue and HashSet
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.offer(0);     // Add into the queue
        int level = 1;      // Set initiate level to be 1

        while(!queue.isEmpty()){
            int size = queue.size();
            // Search all elements in the current level
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