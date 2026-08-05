class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;

        long[]diff = new long[n+1];
        for(int []b : boosts){
            diff[b[0]]+=b[2];

            if(b[1]+1 < n){
                diff[b[1]+1]-=b[2];
            }
        }

        long[] bonus = new long[n];
        long currBonus=0;
        for(int i=0;i<n;i++){
            currBonus+=diff[i];
            bonus[i]=currBonus;
        }

        long hi =0;

        for(int num : monsters){
            hi+=num;
        }

        long lo=0;

        while(lo<hi){
            long mid = lo + (hi-lo)/2;
            if(canDefeat(mid,monsters,bonus)){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }

        return lo;
    }

    private boolean canDefeat(long strength, int[]monsters, long []bonus){
        long curr = strength;

        for(int i=0;i<monsters.length;i++){
            if(curr + bonus[i]<monsters[i]){
                return false;
            }
            curr-=monsters[i];
            if(curr<0){
                curr =0;
            }

            
        }

        return true;
    }
}