class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum=0,cnt=0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int remove = preSum-goal;
            
            cnt+=map.getOrDefault(remove,0);
            
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }

        return cnt == 0 ? 0 : cnt;
        
    }
}