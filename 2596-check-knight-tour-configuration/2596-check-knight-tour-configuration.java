class Solution {
    int[][] dirs = {{-2,-1},{-2,1},{-1,-2},{1,-2},{2,-1},{2,1},{-1,2},{1,2}};
    public boolean checkValidGrid(int[][] grid) {
        int move=0;
        return path(0,0,grid,move);
        
    }
    private boolean path(int row,int col , int[][]grid, int move){
        int n = grid.length;
        if(row>=n || col>=n||row<0 || col<0){
            return false;
        }
        if(grid[row][col]!=move){
            return false;
        }
        if(move == n*n-1){
            return true;
        }

        for(int[]d : dirs){
            int nr = row + d[0];
            int nc = col + d[1];
            if(path(nr,nc,grid,move+1)){
                return true;
            }

        }

        return false;


    }
}