class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> ans = new ArrayList<>();
      Arrays.sort(candidates);
      backtrack(0,target,candidates,ans,new ArrayList<>());

      return ans;
        
    }

    private void backtrack(int start,int target,int[]candidates,List<List<Integer>> ans , List<Integer> curr){
        if(target ==0){
            ans.add(new ArrayList<>(curr));
        }
        if(target<0){
            return;
        }

        for(int i =start ; i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }

            curr.add(candidates[i]);
            backtrack(i+1,target-candidates[i],candidates,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
}