class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n =nums.length;
        Queue<Integer> smallerEl = new LinkedList<>();
        Queue<Integer> greaterEl = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                smallerEl.offer(nums[i]);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                count++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                greaterEl.offer(nums[i]);
            }
        }
        int k=0;
        while(!smallerEl.isEmpty()){
            nums[k]=smallerEl.poll();
            k++;
        }
        while(count>0){
            nums[k]=pivot;
            k++;
            count--;
        }
          while(!greaterEl.isEmpty()){
            nums[k]=greaterEl.poll();
            k++;
        }

        return nums;
        
    }
}