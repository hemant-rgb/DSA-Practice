class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0,nums.length-1,nums);

        return nums;
    }
    private void mergeSort(int low , int high , int[]nums){
        if(low>=high)return;
        int mid = low + (high-low)/2;
        mergeSort(low,mid,nums);
        mergeSort(mid+1,high,nums);
        merge(low,mid,high,nums);
    }

    private void merge(int low, int mid , int high,int[]nums){
        int []temp = new int[high-low+1];
        int i = low ;
        int j = mid+1;
        int k=0;
        while(i<=mid &&j<=high){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }

        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=high){
            temp[k++]=nums[j++];
        }

        for(int p=0;p<temp.length;p++){
            nums[low+p]= temp[p];
        }
    }


}