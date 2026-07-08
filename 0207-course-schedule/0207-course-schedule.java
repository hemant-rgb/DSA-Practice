class Solution {

    private boolean detectCycle(int node , boolean[]visited, boolean[]pathVisited,ArrayList<Integer>[]graph){

        visited[node]= true;
        pathVisited[node]= true;
        for(int neighbour : graph[node]){
            if(!visited[neighbour]){
                if(detectCycle(neighbour,visited,pathVisited,graph)){
                    return true;
                }
            }else if (pathVisited[neighbour]){
                return true;
            }
        }

        pathVisited[node]= false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]= new ArrayList<>();
        }

        for(int [] edge : prerequisites){
            int pre = edge[1];
            int dep = edge[0];
            graph[pre].add(dep);
            
        }

        boolean [] visited = new boolean[numCourses];
        boolean [] pathVisited = new boolean[numCourses];

        for(int i =0;i< graph.length;i++){
            if(!visited[i]){
                if(detectCycle(i,visited,pathVisited,graph)){
                    return false;
                }
            }
        }

        return true;
        
    }
}