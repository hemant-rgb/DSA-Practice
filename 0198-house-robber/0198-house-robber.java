
class Solution {

    private int solve(int n, int[]dp,int[]nums){
        if(n==0) return nums[0];
        if(n==-1) return 0;

        if(dp[n]!=-1)return dp[n];

        int left = nums[n] + solve(n-2,dp,nums);
        int right = solve(n-1,dp,nums);
        return dp[n]= Math.max(left,right);
    }
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1)return nums[0];
        int[]dp = new int[n];
        Arrays.fill(dp,-1);

        dp[0]=nums[0];
        solve(n-1,dp,nums);

        return dp[n-1];

    }
}