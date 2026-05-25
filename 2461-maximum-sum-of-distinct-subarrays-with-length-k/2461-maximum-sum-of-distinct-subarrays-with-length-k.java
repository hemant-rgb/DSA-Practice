class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long maxSum=0,currSum=0;

        int left =0;
        for(int right=0;right<nums.length;right++){
            while(set.contains(nums[right]) || set.size()==k){
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;

            }
            set.add(nums[right]);
            currSum +=nums[right];
            if(set.size()==k){
                maxSum = Math.max(maxSum,currSum);
            }
        }
        return maxSum;
    }
}