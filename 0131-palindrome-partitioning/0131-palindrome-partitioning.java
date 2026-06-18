class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        helper(0,s,ans, new ArrayList<>());


        return ans;
        
    }

    private void helper(int idx, String s, List<List<String>> ans , List<String> curr){
        if(idx==s.length()){
            if(allPalindrome(curr)){
                ans.add(new ArrayList<>(curr));
            }

            return;
        }

        for(int i=idx;i<s.length();i++){
            curr.add(s.substring(idx,i+1));
            helper(i+1,s,ans,curr);
            curr.remove(curr.size()-1);
        }
    }

    private boolean allPalindrome(List<String>curr){
        for(String s : curr){
            if(!isPalindrome(s)){
                return false;
            }
        }

        return true;
    }


    private boolean isPalindrome(String curr){
        int i=0;
        int j = curr.length()-1;
        while(i<j){
            if(curr.charAt(i)!=curr.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}