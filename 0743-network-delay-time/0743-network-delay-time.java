class Solution {
    class Pair implements Comparable<Pair>{
        int n ;
        int path;
        Pair(int n , int path){
            this.n = n;
            this.path=path;
        }

        @Override
        public int compareTo(Pair P2){
            return this.path - P2.path;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for(int i =1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        int []dist = new int[n+1];
        for(int[]time : times){
            int src=time[0];
            int dest = time[1];
            int weight = time[2];
            graph[src].add(new int[]{dest,weight});
           

        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair> pq  =  new PriorityQueue<>();
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int node = curr.n;
            int currDist = curr.path;
            for(int [] next : graph[node]){
                int nextNode  = next[0];
                int weight = next[1];
                if(currDist + weight < dist[nextNode]){
                    dist[nextNode] = currDist + weight;

                    pq.add(new Pair(nextNode , dist[nextNode]));
                }
            }
        }

        int maxTime =0;
        for(int i =1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime,dist[i]);
        }

        return maxTime;
        
    }
}