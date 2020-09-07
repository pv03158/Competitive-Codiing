class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        
        //int ans = helperTabulation(n);
        // int ans = helperMemoized(n, dp);
        // System.out.println(Arrays.toString(dp));
        
        int ans = helperOptimizedTabulation(n);
        return ans;
    }
    
    // RECURSIVE SOLUTION
    private int helperRecursive(int n) {
        // MANAGING CORNER CASES
        if(n < 0 )
            return 0;
        if(n == 0 || n == 1)
            return 1;
        
        int counter = 0;
        counter += helperRecursive(n - 1);
        counter += helperRecursive(n - 2);
        return counter;
    }
    
    // MEMOIZED SOLUTION
    private int helperMemoized(int n, int dp[]) {
        // MANAGING CORNER CASES
        if(n < 0 )
            return 0;
        if(n == 0 || n == 1)
            return dp[n] = 1;
        
        if(dp[n] != 0)
            return dp[n];
        
        int counter = 0;
        counter += helperMemoized(n - 1, dp);
        counter += helperMemoized(n - 2, dp);
        
        return dp[n] = counter;
    }
    
    // TABULIZED SOLUTION
    private int helperTabulation(int n) {
        int N = n;
        int dp[] = new int[N + 1];
        
        for(n = 0; n <= N ; n++) {
            // MANAGING CORNER CASES
            if(n == 0 || n == 1) {
                dp[n] = 1;
                continue;
            }

            int counter = 0;
            counter += dp[n - 1];
            counter += dp[n - 2];

            dp[n] = counter;
        }
        
        return dp[N];
    }
    
    // OPTIMIZED TABULIZED SOLUTION
    private int helperOptimizedTabulation(int n) {
        int N = n;
        int dp[] = new int[2];
        
        for(n = 0; n <= N ; n++) {
            // MANAGING CORNER CASES
            if(n == 0 || n == 1) {
                dp[n] = 1;
                continue;
            }

            int counter = 0;
            counter += dp[(n - 1) % 2];
            counter += dp[(n - 2) % 2];

            dp[n % 2] = counter;
        }
        
        return (n % 2 == 0) ? dp[1] : dp[0];
    }
}