class Solution {
public:
    int minDistance(string s, string p) {
        // MAKING IO FASTER
        std::ios_base::sync_with_stdio(false);
        
        int n = s.length(), m = p.length();
        // HERE IN DP, DP[I][J] MEANS MIN COST TO CONVERT TEXT STRING
        // OF LENGTH I INTO PATTERN STRING OF LENGTH J;
        int dp[n + 1][m + 1];
        
        for(int i = 0 ; i < n + 1 ; i++) {
            for(int j = 0 ; j < m + 1 ; j++) {
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(s.at(i - 1) == p.at(j - 1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = min( dp[i - 1][j - 1],
                                   min(dp[i-1][j], dp[i][j - 1])) + 1;
            }
        }
        
        return dp[n][m];
    }
};