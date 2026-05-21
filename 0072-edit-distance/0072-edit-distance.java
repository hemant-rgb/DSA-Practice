class Solution {
    public int solve(String S1,String S2,int i,int j,int[][]dp){
        if(i==S1.length()){
            return S2.length()-j;
        }
        if(j==S2.length()){
            return S1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(S1.charAt(i)==S2.charAt(j)){
            return dp[i][j] = solve(S1,S2,i+1,j+1,dp);
        }

        int insert = solve(S1,S2,i,j+1,dp);
        int delete = solve(S1,S2,i+1,j,dp);
        int replace = solve(S1,S2,i+1,j+1,dp);

        return dp[i][j]= 1 + Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][]dp = new int[n][m];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }

        return solve(word1,word2,0,0,dp);
        
    }
}