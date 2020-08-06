class Solution {
    public int uniquePaths(int m, int n) {
        return getMazePath(0 ,0 , m - 1, n - 1 , new int[m][n]);
    }
    
    public int getMazePath(int sr, int sc, int er, int ec, int dp[][]) {
        if(sr == er && sc == ec)
            return 1;
        
        if(dp[sr][sc] != 0)
            return dp[sr][sc];
        
        int count = 0;
        if(sr < er ) count += getMazePath(sr + 1, sc , er ,ec, dp);
        if(sc < ec ) count += getMazePath(sr, sc + 1, er, ec, dp);
        
        dp[sr][sc] = count;
        return count;
    }
}