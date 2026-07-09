class Solution {
    private boolean bfs(int src , int end , ArrayList<ArrayList<Integer>> graph,int n){
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n+1];
        q.offer(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==end){
                return true;
            }
            for(int neighbour : graph.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                }
            }
        }

        return false;
    }


    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = edges.length;

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
      
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(!graph.get(u).isEmpty() && !graph.get(v).isEmpty() && bfs(u,v,graph,n)){
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
        


        return new int[]{};
    }
}