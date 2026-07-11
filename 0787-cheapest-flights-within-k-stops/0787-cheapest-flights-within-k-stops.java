class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n];

        for(int i=0;i<n ;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] f: flights){
            graph[f[0]].add(new int[]{f[1],f[2]});
        }

        Queue<int[]> queue =  new LinkedList<>();

        int[]dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src]=0;
        queue.offer(new int[]{src,0,0});

        while(!queue.isEmpty()){
            int[]curr = queue.poll();
            int city = curr[0];
            int cost =curr[1];
            int stop = curr[2];
            if(stop>k){
                continue;
            }

            for(int[] neighbour : graph[city]){
                int next = neighbour[0];
                int price = neighbour[1];

                if(cost + price < dist[next]){
                    dist[next]= cost + price;

                    queue.offer(new int[]{
                        next,
                        cost + price,
                        stop+1
                    });
                }
            }
        } 


        return dist[dst] ==Integer.MAX_VALUE ? -1: dist[dst];       
    }
}