class Solution {

    private boolean dfs(int src, int dest, ArrayList<ArrayList<Integer>> graph,boolean[]visited){
        if(src==dest){
            return true;
        }
        visited[src]= true;

        for(int neighbour : graph.get(src)){
            if(!visited[neighbour]){
                if(dfs(neighbour,dest,graph,visited)){
                    return true;
                }
            }
        }

        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int []edge: edges){
            int u = edge[0];
            int v = edge[1];
            boolean[] visited = new boolean[edges.length+1];

            if(!graph.get(u).isEmpty() && !graph.get(v).isEmpty() && dfs(u,v,graph,visited)){
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[]{};
    }
}