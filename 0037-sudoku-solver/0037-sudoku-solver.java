class Solution {
    public void solveSudoku(char[][] board) {
        helper(0,0,board);  
    }

    private boolean helper(int row,int col , char[][]board){
        if(row == board.length){
            return true;
        }
        if(col==board.length){
            
            return helper(row+1,0,board);
        }
        if(board[row][col]!='.'){

            return helper(row,col+1,board);
        }

        for(int i=1;i<=9;i++){
            if(isValid(row,col,i,board)){
                board[row][col]= (char)(i + '0');
                if(helper(row,col+1,board)){
                    return true;
                }
                board[row][col]='.';
            }

        }

        return false;


    }

    private boolean isValid(int row , int col , int i,char[][]board){
        char num = (char)(i + '0');
        // row
        for(int c=0;c<board.length;c++){
            if(board[row][c]==num){
                return false;
            }
        }
        // col
        for(int r=0;r<board.length;r++){
            if(board[r][col]==num){
                return false;
            }
        }

        int srow=(row/3)*3;
        int scol=(col/3)*3;

        // block
        for(int r=srow;r<srow+3;r++){
            for(int c = scol;c<scol+3;c++){
                if(board[r][c]==num){
                    return false;

                }
            }
        }

        return true;

    }
}