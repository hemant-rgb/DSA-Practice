class Solution {
    class DSU {
        int[]rank;
        int[]parent;
        int extraEdge;
        DSU(int n ){
            rank = new int[n];
            parent= new int[n];
            for(int i=0;i<n;i++){
                rank[i]=0;
                parent[i]=i;
            }
        }


        public int findParent(int x){
            if(x == parent[x])return x;

            return  parent[x]= findParent(parent[x]);
        }


        public void unionByRank(int u , int v){
            int parU = findParent(u);
            int parV = findParent(v);
            if(parU==parV){
                extraEdge++;
                return;

            }
            if(rank[parU]<rank[parV]){
                parent[parU]=parV;

            }else if (rank[parU]>rank[parV]){
                parent[parV]=parU;
            }else{
                parent[parU]=parV;
                rank[parV]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        DSU dsu = new DSU(n);
        for(int i=0;i<len;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(u==v)continue;

            dsu.unionByRank(u,v);
        }
        int comp=0;
        for(int i=0;i<n;i++){
            if(dsu.parent[i]==i){
                comp++;
            }

        }

        if(dsu.extraEdge>=comp-1){
            return comp-1;
        }



        return -1;






        
    }
}