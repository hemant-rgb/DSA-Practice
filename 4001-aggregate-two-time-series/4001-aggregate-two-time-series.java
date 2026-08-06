class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n =series1.length;
        int m = series2.length;
        int i=0,j=0;

        List<List<Integer>> ans = new ArrayList<>();

        while(i<n || j<m){
            int t1 = (i<n) ? series1[i][0]: Integer.MAX_VALUE;
            int t2 = (j<m) ? series2[j][0] : Integer.MAX_VALUE;

            int time = Math.min(t1,t2);
            int v1 = (i<n) ? series1[i][1] : 0;
            int v2 = (j<m) ? series2[j][1] : 0;

            ans.add(Arrays.asList(time , v1+v2));

            if(i<n && series1[i][0]==time) i++;
            if(j<m && series2[j][0]==time) j++;
            
        }


        return ans;
        
    }
}