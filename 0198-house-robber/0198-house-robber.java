
class Solution {

    // private int solve(int n, int[]dp,int[]nums){
    //     if(n==0) return nums[0];
    //     if(n==-1) return 0;

    //     if(dp[n]!=-1)return dp[n];

    //     int left = nums[n] + solve(n-2,dp,nums);
    //     int right = solve(n-1,dp,nums);
    //     return dp[n]= Math.max(left,right);
    // }
    // public int rob(int[] nums) {
    //     int n= nums.length;
    //     if(n==1)return nums[0];
    //     int[]dp = new int[n];
    //     Arrays.fill(dp,-1);

    //     dp[0]=nums[0];
    //     solve(n-1,dp,nums);

    //     return dp[n-1];

    // }

    public int rob(int []nums){
        // int n = nums.length;
        // if(n==0)return 0;
        // if(n==1)return nums[0];
        // if(n==2) return Math.max(nums[0],nums[1]);

        // int[]dp = new int[n];
        // dp[0]= nums[0];
        
        // for(int i=1;i<n;i++){
        //     int left = nums[i];
        //     if(i>1){
        //         left += dp[i-2];

        //     }
            
        //     int right = dp[i-1];

        //     dp[i]= Math.max(left,right);

        // }

        // return dp[n-1];

        int n = nums.length;
        if(n==0)return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int prev1 = nums[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int left =prev2 + nums[i];
            

            int right = prev1;
            int curr = Math.max(left,right);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

        
    }
}