class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;
        int m = landStartTime.length;
        int n = waterStartTime.length;
        
        for(int i =0;i<m ; i++){
            int landfinish = landStartTime[i]+ landDuration[i];
            for(int j =0;j<n;j++){
                int waterstart = Math.max(landfinish,waterStartTime[j]);
                int finish1 = waterstart + waterDuration[j];
                ans = Math.min(ans,finish1);

                int waterfinish = waterStartTime[j]+waterDuration[j];
                int landstart = Math.max(waterfinish,landStartTime[i]);
                int finish2 = landstart + landDuration[i];
                ans = Math.min(ans,finish2);

            }

            
        }

        return ans;
    }
}