class Solution {
    List<List<Integer>> result = new ArrayList<>();
    private void swap(int[]nums,int idx,int i){
        int temp = nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
    }
    private void solve(int [] nums , int idx){
        if(idx == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for(int n : nums){
                permutation.add(n);
            }
            result.add(permutation);
            return;
        }

        for(int i =idx;i<nums.length;i++){
            swap(nums,idx,i);
            solve(nums,idx+1);
            swap(nums,idx,i);
            
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        solve(nums,0);
        return result;
        
    }
}