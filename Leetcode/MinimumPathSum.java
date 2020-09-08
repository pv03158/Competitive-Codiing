class Solution {
    public int minPathSum(int[][] grid) {
        // int ans = getMinSum(grid, 0, 0);
        
        // int dp[][] = new int[grid.length][grid[0].length];
        // int ans = getMinSumMEMOIZED(grid, 0, 0, dp);
        
        // for(int idx = 0 ; idx < dp.length ; idx++)
        //     System.out.println(Arrays.toString(dp[idx]));
        
        int ans = getMinSumTABULATION(grid);
        return ans;
    }
    
    // RECURSIVE APPROACH TO SOLVE THE PROBLEM
    private int getMinSum(int[][] arr, int row, int col) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        if(row == rows - 1 && col == cols -1)
            return arr[row][col];
        
        int curr = arr[row][col];
        int subsol1 = (row + 1 < rows) 
                        ? getMinSum(arr, row + 1, col) 
                        : Integer.MAX_VALUE;
        
        int subsol2 = (col + 1 < cols) 
                        ? getMinSum(arr, row, col + 1)
                        : Integer.MAX_VALUE;
        
        return Math.min(subsol1, subsol2) + curr;
    }
    
    // MEMOIZED APPROACH TO SOLVE THE PROBLEM
    private int getMinSumMEMOIZED(int[][] arr, int row, int col, int dp[][]) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        if(row == rows - 1 && col == cols -1)
            return dp[row][col] = arr[row][col];
        
        if(dp[row][col] != 0) return dp[row][col];
        
        int curr = arr[row][col];
        int subsol1 = (row + 1 < rows) 
                        ? getMinSumMEMOIZED(arr, row + 1, col, dp) 
                        : Integer.MAX_VALUE;
        
        int subsol2 = (col + 1 < cols) 
                        ? getMinSumMEMOIZED(arr, row, col + 1, dp)
                        : Integer.MAX_VALUE;
        
        return dp[row][col] = Math.min(subsol1, subsol2) + curr;
    }
    
    // TABULIZED APPROACH TO SOLVE THE PROBLEM
    private int getMinSumTABULATION(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        int dp[][] = new int[rows][cols];
        for(int row = rows - 1 ; row >= 0 ; row--) {
            for(int col = cols - 1 ; col >= 0 ; col--) {
                
                if(row == rows - 1 && col == cols -1) {
                    dp[row][col] = arr[row][col];
                    continue;
                }


                int curr = arr[row][col];
                int subsol1 = (row + 1 < rows) 
                                ? dp[row + 1][col] : Integer.MAX_VALUE;

                int subsol2 = (col + 1 < cols) 
                                ? dp[row][col + 1] : Integer.MAX_VALUE;

                dp[row][col] = Math.min(subsol1, subsol2) + curr;    
            }
        }
        
//         for(int idx = 0 ; idx < dp.length ; idx++)
//             System.out.println(Arrays.toString(dp[idx]));
              
        return dp[0][0];
    }
    
}