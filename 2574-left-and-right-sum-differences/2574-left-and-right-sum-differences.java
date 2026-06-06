class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n =nums.length;
        int[]left = new int[n];
        int[]ans = new int[n];
        int[]right = new int[n];
        int pre=0;
        
        for(int i=0;i<n;i++){
            left[i]=pre;
            pre +=nums[i];
        }
        int post=0;
        for(int i=n-1;i>=0;i--){
            right[i]=post;
            post +=nums[i];
        }
        for(int i=0;i<n;i++){
            ans[i]= Math.abs(left[i]-right[i]);
        }
        return ans;
        
    }
}