class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int preSum=0,cnt=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int remove = preSum-k;
            if(map.containsKey(remove)){
                 cnt+=map.get(remove);
            }
           
            map.put(preSum,map.getOrDefault(preSum,0)+1);

        }

        return cnt;
        
    }
}