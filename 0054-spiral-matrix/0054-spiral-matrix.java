class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        int l=0,r=col-1;
        int t=0,b=row-1;
        List<Integer> ans = new ArrayList<>();
        while(t<=b && l<=r){
            for(int j=l;j<=r;j++){
                ans.add(matrix[t][j]);
                
            }
            t++;
            for(int i=t;i<=b;i++){
                ans.add(matrix[i][r]);
            }
            r--;
            
            if(t<=b){
                for(int j=r;j>=l;j--){
                    ans.add(matrix[b][j]);
                }
                b--;
            }
            if(l<=r){
                for(int i=b;i>=t;i--){
                    ans.add(matrix[i][l]);
                }
                l++;
            }


        }

        return ans;
        
    }
}