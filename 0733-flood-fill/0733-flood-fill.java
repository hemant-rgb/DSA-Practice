class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
        if(originalColor ==color){
            return image;
        }
        
        Queue<int[]> q = new LinkedList<>();
        

        q.offer(new int[]{sr,sc});
        image[sr][sc]=color;
        int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};


        while(!q.isEmpty()){
            int [] curr = q.poll();
            int row= curr[0];
            int col = curr[1];
            
            for(int [] d : dirs){
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr >=0 && nr < m && nc>=0 && nc<n && image[nr][nc]==originalColor){
                    q.offer(new int[]{nr,nc});
                    image[nr][nc]=color;
                }

            }
        }


        return image;
        
    }
}