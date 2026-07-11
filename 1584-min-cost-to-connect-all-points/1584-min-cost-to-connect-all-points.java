class Solution {


    class DSU{
        int[]parent;
        int []rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }

            return parent[x];

        }

        boolean union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py){
                return false;
            }

            if(rank[px]==rank[py]){
                parent[px]=py;
                rank[py]++;
            }else if(rank[px]<rank[py]){
                parent[px]=py;
                
            }else{
                parent[py]=px;
                
            }

            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> edges = new ArrayList<>();

        for(int i=0;i<n ;i++){
            for(int j=i+1;j<n;j++){
                int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);

                edges.add(new int[]{i,j,cost});
            }
        }
        edges.sort((a,b)-> a[2]-b[2]);

        DSU dsu = new DSU(n);
        int answer =0;
        int used=0;

        for(int []edge : edges){
            if(dsu.union(edge[0],edge[1])){
                answer+=edge[2];
                used++;
                if(used ==n-1){
                    break;
                }
            }
        }

        return answer;

        
    }
}