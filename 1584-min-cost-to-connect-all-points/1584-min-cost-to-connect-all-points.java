class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[]visited = new boolean[n];
        PriorityQueue<int[]> pq =new PriorityQueue<>(
            (a,b)-> a[0]-b[0]
        );
        pq.offer(new int[]{0,0});
        int ans=0;
        int nodeCount=0;
        while(nodeCount<n){
            int[] curr = pq.poll();
            int cost =curr[0];
            int node = curr[1];

            if(visited[node]==true){
                continue;
            }
            visited[node]=true;
            ans+=cost;
            nodeCount++;

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    int dist = Math.abs(points[node][0]-points[i][0]) + Math.abs(points[node][1]-points[i][1]);
                    pq.offer(new int[]{
                        dist,i
                    });
                }
            }
        }


        return ans;
        
    }
}