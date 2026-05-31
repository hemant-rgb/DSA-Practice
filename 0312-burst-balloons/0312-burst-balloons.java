class Solution {
    int [][]dp;
    int []arr;
    private int solve(int left,int right){
        if(left+1 == right){
            return 0;
        }

        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int maxCoins=0;
        for(int k=left+1; k<right;k++){
            int coins = arr[left]*arr[k]*arr[right];
            maxCoins = Math.max(maxCoins, coins + solve(left,k) + solve(k, right));

        }

        return dp[left][right]=maxCoins;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        arr = new int [n+2];
        dp = new int[n+2][n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i =0;i<nums.length;i++){
            arr[i+1]=nums[i];
        }
        for(int [] row : dp ){
            Arrays.fill(row,-1);
        }
        return solve(0,n+1);
        
    }
}