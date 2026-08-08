class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int prev1 = nums[0];
        int prev2 =0;
        for(int i=1;i<n-1;i++){
            int left = nums[i]+ prev2;
            int right = prev1;
            int curr = Math.max(left,right);
            prev2 = prev1;
            prev1=curr;
        }

        int first = prev1;

        prev2 = 0;
        prev1 = nums[1];
        for(int i=2;i<n;i++){
            int left = prev2 + nums[i];
            int right = prev1;
            int curr = Math.max(left,right);
            prev2 = prev1;
            prev1 = curr;
        }

        int second = prev1;

        return Math.max(first,second);
        
    }
}