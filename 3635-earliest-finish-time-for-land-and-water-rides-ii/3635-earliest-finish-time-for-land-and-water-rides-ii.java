class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int m =landStartTime.length;
        int n = waterStartTime.length;
        

        long minLandFinish=Long.MAX_VALUE;
        for(int i=0;i<m ;i++){
            minLandFinish = Math.min((long) landStartTime[i]+landDuration[i],minLandFinish);
        }
        long landToWaterMin = Long.MAX_VALUE;
        for(int j =0;j<n;j++){
           long startWater = Math.max(waterStartTime[j] , minLandFinish);
           long waterFinish = startWater + waterDuration[j];
           landToWaterMin = Math.min(landToWaterMin, (long) waterFinish);
        }
        long minWaterFinish=Long.MAX_VALUE;
        for(int i=0;i<n ;i++){
            minWaterFinish = Math.min((long) waterStartTime[i]+waterDuration[i],minWaterFinish);
        }
        long waterToLandMin = Long.MAX_VALUE;
        for(int j =0;j<m;j++){
           long startLand = Math.max(landStartTime[j] , minWaterFinish);
           long landFinish = startLand + landDuration[j];
           waterToLandMin = Math.min(waterToLandMin, (long) landFinish);
        }

        return (int) Math.min(landToWaterMin,waterToLandMin);
        
    }
}