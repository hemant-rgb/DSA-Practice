class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList< Integer>[] graph = new ArrayList[numCourses];
       for(int i=0;i<graph.length;i++){
        graph[i]= new ArrayList<>();
       }

       int [] indeg = new int[graph.length];

       for(int []pre : prerequisites){
        
        graph[pre[1]].add(pre[0]);
        indeg[pre[0]]++;

       }


       Queue<Integer> q = new LinkedList<>();
       for(int i=0;i<numCourses;i++){
        if(indeg[i]==0){
            q.add(i);
        }

       }

       int ans[] = new int[numCourses];
       int idx=0;
       while(!q.isEmpty()){
        int curr = q.remove();
        ans[idx++]=curr;
        for(int i=0;i<graph[curr].size();i++){
            int dest = graph[curr].get(i);
            indeg[dest]--;
            if(indeg[dest]==0){
                q.add(dest);
            }
        }

       }

       if(idx != numCourses){
           return new int[0];
       }

       return ans;
       
        
    }
}