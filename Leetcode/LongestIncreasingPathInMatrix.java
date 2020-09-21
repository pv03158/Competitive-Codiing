class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length; 
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        
        int maxlength = 0;
        int[][] vis = new int[m][n];
        for(int i = 0 ; i < m ; i++) 
            for(int j = 0 ; j < n ; j++) 
                maxlength = Math.max(maxlength, dfs(matrix, i, j , vis));
        
        return maxlength;
    }
    
    private int dfs(int[][] mat, int i, int j, int[][] vis) {
        int m = mat.length - 1;
        int n = mat[0].length - 1;
        
        if(vis[i][j] != 0)
            return vis[i][j];
        
        vis[i][j] = 1;
        int dir[][] = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        for(int idx = 0 ; idx < dir.length; idx++) {
            int r = i + dir[idx][0];
            int c = j + dir[idx][1];
            
            if( r >= 0 && r <= m && c >= 0 && c <= n)
                if(mat[i][j] < mat[r][c])
                    vis[i][j] = Math.max( vis[i][j], dfs(mat, r, c, vis) + 1);
        }
        
        return vis[i][j];
    }
}