class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        for(int[]edge : prerequisites){
            int pre = edge[1];
            int dep = edge[0];
            graph.get(pre).add(dep);
            indegree[dep]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int count=0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neighbour: graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);

                }

            }
        }

        return count == numCourses;

        
    }
}