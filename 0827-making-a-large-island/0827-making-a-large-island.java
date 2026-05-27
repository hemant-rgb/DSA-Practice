class Solution {
    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int [][] grid ;
    public int n;
    
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;

        HashMap<Integer,Integer> islandSize = new HashMap<>();
        int islandId =2;
        int maxSize=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int size = dfs(i,j,islandId);
                    islandSize.put(islandId,size);
                    maxSize = Math.max(maxSize,size);
                    islandId++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> seen = new HashSet<>();
                    int currSize=1;
                    for(int []d :dir){
                        int nr = i+d[0];
                        int nc= j + d[1];
                        if(nr>=0 && nc>=0 && nr<n && nc<n){
                            int id = grid[nr][nc];
                            if(id>1 && !seen.contains(id)){
                               currSize += islandSize.get(id);
                               seen.add(id);
                            }

                        }
                        
                    }
                    maxSize= Math.max(maxSize,currSize);
                }
            }
        }

        return maxSize;
        
    }

    public int dfs(int r,int c,int islandId){
        if(r<0 || c<0 || r>=n || c>=n || grid[r][c]!=1){
            return 0;
        }
        int size =1;
        grid[r][c]=islandId;

        for(int []d : dir){
            size+= dfs(r+d[0],c+d[1],islandId);
        }

        return size;


    }
}