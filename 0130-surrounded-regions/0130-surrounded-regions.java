class Solution {
    private int rows;
    private int cols;

    private void dfs(char[][]board,int row,int col){
        if(row<0 || col<0 || row>=rows || col>=cols || board[row][col]!='O'){
            return;
        }

        board[row][col]='#';

        dfs(board, row+1 ,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }
    public void solve(char[][] board) {
        rows = board.length;
        cols=board[0].length;

        for(int c =0; c<cols;c++){
            dfs(board,0,c);
            dfs(board,rows-1,c);
        }
        for(int r =0;r<rows;r++){
            dfs(board,r,0);
            dfs(board,r,cols-1);
        }

        for(int i=0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }

        
    }
}