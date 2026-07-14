class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][]dist = new int[n][n];
        int INF = (int)1e9;
        for(int i =0;i<n;i++){
            Arrays.fill(dist[i],INF);
        }
        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }

        for(int[]edge : edges){
            dist[edge[0]][edge[1]]= edge[2];
            dist[edge[1]][edge[0]]= edge[2];
        }
        for(int via =0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]== INF || dist[via][j]==INF){
                        continue;
                    }
                    dist[i][j]= Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                }
            }
        }
        int city=-1;
        int minReachable=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=distanceThreshold){
                    count++;
                }
            }

            if(count <=minReachable){
                minReachable=count;
                city=i;

            }
        }

        return city;
        
    }
}