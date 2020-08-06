class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int nr = obstacleGrid.length;
        int nc = obstacleGrid[0].length;
        return getPaths(obstacleGrid, 0 ,0, new int[nr+1][nc+1]);
    }
    
    public int getPaths(int grid[][], int cr, int cc, int dp[][]) {
        int er = grid.length - 1;
        int ec = grid[0].length - 1;
        if( cr == er && cc == ec && grid[cr][cc] == 0)
            return 1;
        
        if(grid[cr][cc] == 1) 
            return 0;
        
        if(dp[cr][cc] != 0)
            return dp[cr][cc];
        
        int count = 0;
        if( cr < er ) count += getPaths(grid, cr+1, cc, dp);
        if( cc < ec ) count += getPaths(grid, cr, cc+1, dp);
        
        dp[cr][cc] = count;
        return count;
    }
}