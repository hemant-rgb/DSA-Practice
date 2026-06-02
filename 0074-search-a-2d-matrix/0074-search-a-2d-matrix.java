class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=m-1;
        int j = 0;

        while(i>=0 && j>=0 && i<m && j<n){
            if(matrix[i][j]==target){
                return true;
            }else if (matrix[i][j]>target){
                i--;
            }else{
                j++;
            }
        }

        return false;
        
    }
}