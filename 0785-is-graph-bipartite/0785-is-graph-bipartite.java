class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int start=0;start<n;start++){
            if(colour[start]!=0){
                continue;
            }

            colour[start]=1;
            q.offer(start);
        

            while(!q.isEmpty()){
                int curr = q.poll();

                for(int neighbor : graph[curr]){
                    if(colour[neighbor]==0){
                        colour[neighbor] = colour[curr] == 1 ? 2 : 1;
                        q.offer(neighbor);
                    }else if(colour[neighbor]==colour[curr]){
                        return false;
                    }
                }

            }

        }


        return true;
        
        
    }
}