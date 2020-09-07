class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        int ans = helperTabulation(m, n);
        
        // PRINTING DP
        // for(int[] arr : dp)
        //     System.out.println(Arrays.toString(arr));
        
        return ans;
    }
    
    // RECURSIVE SOLUTION OF THE PROBLEM
    private int helperRecursive(int m, int n, int row, int col) {
        // MANAGING CORNER CASES
        if(row >= m || col >= n)
            return 0;
        if(row == m - 1 && col == n - 1 )
            return 1;
        
        // IF MOVING IN DOWN DIRECTION
        int down = helperRecursive(m, n, row + 1, col);
        // IF MOVING IN RIGHT DIRECTION
        int right = helperRecursive(m, n , row, col + 1);
        return down + right;
    }
    
    // MEMOIZED SOLUTION OF THE PROBLEM
    private int helperMemoized(int m, int n, int row, int col, int[][] dp) {
        // MANAGING CORNER CASES
        if(row >= m || col >= n)
            return 0;
        if(row == m - 1 && col == n - 1 )
            return 1;
        
        // CHECKING WHETHER SOLUTION EXISTS IN DP
        if(dp[row][col] != 0)
            return dp[row][col];
        
        // IF MOVING IN DOWN DIRECTION
        int down = helperMemoized(m, n, row + 1, col, dp);
        // IF MOVING IN RIGHT DIRECTION
        int right = helperMemoized(m, n , row, col + 1, dp);
        
        return dp[row][col] = down + right;
    }
    
    // TABULIZED SOLUTION OF THE PROBLEM
    private int helperTabulation(int m, int n) {
        
        int dp[][] = new int[m + 1][n + 1];
        
        for(int row = m - 1; row >= 0 ; row --) {
            for(int col = n -1 ; col >= 0 ; col --) {
                // MANAGING CORNER CASES
                if(row == m - 1 && col == n - 1 ) {
                    dp[row][col] = 1;
                    continue;
                }

                // IF MOVING IN UP DIRECTION
                int up = dp[row + 1][col];
                // IF MOVING IN LEFT DIRECTION
                int left = dp[row][col + 1];

                dp[row][col] = up + left;       
            }    
        }
        
        return dp[0][0];
    }
}