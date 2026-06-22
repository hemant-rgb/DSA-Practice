class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int []ans = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    map.put(i,j);
                    break;
                }
            }
        }

        for(int i =0;i<nums1.length;i++){
            int j = map.get(i);
            int val = nums2[j];
            int p = j+1;
            while(p<nums2.length){
                if(nums2[p]>val){
                    break;
                }
                p++;
                
            }
            ans[i] = p == nums2.length ? -1 : nums2[p];

        }

        return ans;
        
    }
}