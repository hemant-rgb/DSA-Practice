class Solution {
    private int helper(int[]arr,int i){
        if(i==arr.length-1){
            return i;
        }else if(arr[i]>arr[i+1]){
            return i;
        }else{
            return helper(arr,i+1);
        }

        

    }
    public int peakIndexInMountainArray(int[] arr) {
        return helper(arr,0);
        
    }
}