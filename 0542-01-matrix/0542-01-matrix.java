class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    ans[i][j]=-1;
                }
            }
        
        }
        int[][]dirs ={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int []curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int []d : dirs){
                int nr =row + d[0];
                int nc = col + d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && ans[nr][nc]==-1){
                    ans[nr][nc]= ans[row][col]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        return ans;
        
    }
}