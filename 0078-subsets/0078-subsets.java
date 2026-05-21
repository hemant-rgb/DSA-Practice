class Solution {
    List<List<Integer>> result = new ArrayList<>();
    private void solve(int[]nums,int idx,List<Integer> curr){
        if(idx==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        solve(nums,idx+1,curr);
        curr.remove(curr.size()-1);
        solve(nums,idx+1,curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        solve(nums,0,new ArrayList<>());
        return result;
        
    }
}