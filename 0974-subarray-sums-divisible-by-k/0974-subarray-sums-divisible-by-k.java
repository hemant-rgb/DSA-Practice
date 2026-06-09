class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum=0,cnt=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];

            int remove = preSum % k;
            if(remove<0){
                remove+=k;
               
            } 
            cnt+=map.getOrDefault(remove,0);

            map.put(remove,map.getOrDefault(remove,0)+1);

        }

        return cnt;
        
    }
}