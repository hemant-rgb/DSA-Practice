class Solution {
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!isAlnum(l)){
                left++;
            }
            else if(!isAlnum(r)){
                right--;
            }
            else{
                if(Character.toLowerCase(l)!=Character.toLowerCase(r)){
                    return false;

                }

                left++;
                right--;
                

            }
        }
        return true;
        
    }

    public boolean isAlnum(char c){
        if(c>='A'&& c<='Z'|| c>='a'&&c<='z'||c>='0'&& c<='9'){
            return true;
        }
        return false;
    }
}