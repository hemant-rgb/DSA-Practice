class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low =1;
        int high =0;
        for(int q : quantities){
            high = Math.max(high,q);
        }

        while(low<high){
            int mid = low + (high-low)/2;

            if(canDistribute(quantities,n,mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        
        }
        return low;
    }

    private boolean canDistribute(int[]quantities,int n ,int x){
        int storesNeeded=0;
        for(int q : quantities){
            storesNeeded+= (q+x-1)/x;
            if(storesNeeded>n){
                return false;
            }

        }
        return true;
    }
}