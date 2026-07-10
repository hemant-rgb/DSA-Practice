class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n =prerequisites.length;
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[]indegree = new int[numCourses];
        for(int []edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            indegree[u]++;

        }

        Queue<Integer> q = new LinkedList<>();
        int[]ans = new int[numCourses];
        int index =0;

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[index++]= curr;

            for(int neighbour: graph.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }

        return index==numCourses ? ans : new int[]{};


    
        
    }
}