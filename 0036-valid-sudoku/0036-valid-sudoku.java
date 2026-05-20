class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row[][]=new boolean[9][9];
        boolean col[][]=new boolean[9][9];
        boolean boxes[][]=new boolean[9][9];

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char ch=board[r][c];
                if(ch=='.'){
                    continue;
                }
                int num =ch -'1';

                int box = (r/3)*3 + c/3;

                if(row[r][num]|| col[c][num] || boxes[box][num]){
                    return false;
                }
                row[r][num]=true;
                col[c][num]=true;
                boxes[box][num]=true;



            }
        }

        return true;
        
    }
}