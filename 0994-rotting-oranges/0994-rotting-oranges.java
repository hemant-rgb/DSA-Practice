class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q= new LinkedList<>();
       
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        int time=0;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                     q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }else{
                    continue;
                }
            }
        }

        if(fresh==0){
            return 0;
        }

       while(!q.isEmpty() && fresh>0){
        int size = q.size();
        for(int i =0;i<size;i++){
            int [] curr = q.poll();
            for(int[]d : dirs){
                int nr = curr[0]+d[0];
                int nc = curr[1]+d[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n  && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        time++;
       }

        
        return fresh == 0 ? time : -1;
    }
}