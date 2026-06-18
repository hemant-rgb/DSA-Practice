class Solution {
    List<List<String>> ans = new ArrayList<>() ;
    Set<Integer> col = new HashSet<>();
    Set<Integer> dia1 = new HashSet<>();
    Set<Integer> dia2 = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][]board = new char[n][n];
        for(char []row : board){
            Arrays.fill(row,'.');
        }


        helper(0,n,board);
        return ans;

        
    }

    private void helper(int row , int n , char[][]board){
        if(row==n){
            ans.add(construct(board));
            return;
        }

        for(int c=0;c<n;c++){
            int d1= row-c;
            int d2 = row+c;
            if(col.contains(c)|| dia1.contains(d1) || dia2.contains(d2)){
                continue;
            }

            board[row][c]='Q';
            col.add(c);
            dia1.add(d1);
            dia2.add(d2);

            helper(row+1,n,board);
            board[row][c]='.';
            col.remove(c);
            dia1.remove(d1);
            dia2.remove(d2);
        }
    }

    private List<String> construct(char[][]board){
        List<String> res = new ArrayList<>();
        for(char[]row : board){
            res.add(new String(row));
        }

        return res;
    }
}