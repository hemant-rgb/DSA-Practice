class Solution {
    private int square(int n){
        int ans=0;
        while(n>0){
            int x = n%10;
            ans+= x*x;
            n=n/10;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        int slow = square(n);
        int fast = square(square(n));

        while(slow!=fast){
            slow=square(slow);
            fast=square(square(fast));
        }

        return slow==1;
        
    }
}