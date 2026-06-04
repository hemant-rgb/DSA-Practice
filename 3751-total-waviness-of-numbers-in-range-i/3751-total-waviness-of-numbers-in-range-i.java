class Solution {
    private int getWaviness(int num){
        String s = String.valueOf(num);
        int waviness=0;
        for(int i = 1;i<s.length()-1;i++){
            int left = s.charAt(i-1)-'0';
            int val = s.charAt(i)-'0';
            int right = s.charAt(i+1)-'0';
            if((left<val && right <val) || (left>val && right>val)){
                waviness++;
            }
        }
        return waviness;
    }
    public int totalWaviness(int num1, int num2) {
        int ans =0;
        for(int i=num1 ;i<=num2;i++){
            ans +=getWaviness(i);

        }
        return ans;
    }
}