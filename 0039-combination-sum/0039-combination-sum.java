class Solution {



    private void backTrack(int []candidates,int target,int start,List<List<Integer>> res,List<Integer> current){
        if(target==0){
            res.add(new ArrayList<>(current));
            return ;
        }else if(target <0){
            return ;
        }else{

            for(int i=start;i<candidates.length;i++){
                current.add(candidates[i]);
                backTrack(candidates,target-candidates[i],i,res,current);
                current.remove(current.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();

        backTrack(candidates,target,0,res,new ArrayList<>());
        return res;
        
    }
}