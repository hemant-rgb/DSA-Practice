class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean [] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});
        int totalSum = 0;
        int edgeCount = 0;
        while(edgeCount<n){
            int [] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            if(visited[node]) continue;
            visited[node]=true;
            totalSum+=cost;
            edgeCount++;
            for(int next =0;next<n; next++){
                if(!visited[next]){
                    int dist = Math.abs(points[node][0] - points[next][0]) + Math.abs(points[node][1] - points[next][1]);
                    pq.offer(new int[]{dist,next});
                }
            }
        }

        return totalSum;

        
    }
}