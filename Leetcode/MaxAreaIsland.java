class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int maxarea = 0;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0 ; i < m ; i++) 
            for(int j = 0; j < n ; j++) 
                maxarea = Math.max(maxarea, dfs(grid, i, j , vis));
        
        return maxarea;
    }
    
    private int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        int m = grid.length; 
        int n = grid[0].length;
        if(vis[i][j] || grid[i][j] == 0)
            return 0;
        
        int asf = 1;
        vis[i][j] = true;
        int dir[][] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        for(int idx = 0 ; idx < dir.length; idx++) {
            int r = i + dir[idx][0];
            int c = j + dir[idx][1];
            if(r >= 0 && c >= 0 && r < m && c < n)
                asf += dfs(grid, r, c, vis);
        }
        
        return asf;
    }
}