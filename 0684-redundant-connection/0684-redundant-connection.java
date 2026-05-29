class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[]parent = new int[n+1];
        int[]rank = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }

        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(!union(u,v,parent,rank)){
                return edge;
            }
        }
        return new int[]{};
    }
     private int find(int node, int[] parent) {

        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }

        return parent[node];
    }

    public boolean union(int u , int v , int[]parent , int[]rank){
        int paru = find(u,parent);
        int parv = find(v,parent);
        if(paru == parv){
            return false;
        }

        if(rank[paru]>rank[parv]){
            parent[parv]=paru;
        }else if(rank[paru]<rank[parv]){
            parent[paru]=parv;
        }else{
            parent[paru]=parv;
            rank[parv]++;
        }
        return true;
    }
}