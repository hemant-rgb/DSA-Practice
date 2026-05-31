class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean visited[][]= new boolean[n][n];
        pq.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=true;

        int [][]directions ={{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            int[]curr = pq.poll();
            int time = curr[0];
            int r= curr[1];
            int c = curr[2];
            if(r==n-1 && c== n-1){
                return time;

            }

            for(int []dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    pq.offer(
                        new int[]{
                            Math.max(time,grid[nr][nc]),nr,nc
                        }
                    );
                }

            }
        }

        return -1;
        
    }
}