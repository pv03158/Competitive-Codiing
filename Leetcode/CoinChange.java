// LEETCODE - 322 COIN-CHANGE PROBLEM

class Solution {
    public int coinChange(int[] coins, int amount) {
        int solution = getCoinChange(coins, amount, new int[amount + 1] );
        if(solution >= (int)10e8 )
            return -1;
        else
            return solution;
    }
    
    public int getCoinChange(int[] coins, int amount, int dp[]) {
        if(amount < 0)
            return (int) 10e8;
        
        if(amount == 0)
            return 0;
        
        if(dp[amount] != 0)
            return dp[amount];
        
        int subsolution = (int) 10e8;
        for(int idx = 0 ; idx < coins.length ; idx++)
            // FAITH - RECURSIVE FUNCTION RETURNS MIN NUMBER OF COINS REQUIRE
            // FOR AMOUNT - COINS[IDX]
            subsolution = Math.min(getCoinChange(coins, amount - coins[idx], dp),
                                      subsolution);
        
        int solution = subsolution + 1;
        dp[amount] = solution;
        return solution;
    }
}