class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] col = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(col[i]==0){
                q.add(i);
                col[i]=1;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j =0 ;j<graph[curr].length;j++){
                        int n = graph[curr][j];
                        if(col[n]==0){
                            int nextcol = col[curr] == 1 ? 2 : 1;
                            col[n]=nextcol;
                            q.add(n);
                        }else if(col[n]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
        
    }
}