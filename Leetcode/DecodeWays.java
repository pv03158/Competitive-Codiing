// LEETCODE PROBLEM - 91 DECODE WAYS

class Solution {
    public int numDecodings(String str) {
        return solve(str,0,new int[str.length()]);
    }
    
    public int solve(String str, int cidx, int dp[]) {
        if(cidx == str.length())
            return 1;
        
        if(dp[cidx] != 0)
            return dp[cidx];
        
        int counter = 0;
        if( cidx + 1 <= str.length() ) {
            int val = Integer.valueOf(str.substring(cidx,cidx+1));
            if(val >= 1 && val <= 9)
                counter += solve(str,cidx+1,dp);
        }
        if( cidx + 2 <= str.length() ) {
            int val = Integer.valueOf(str.substring(cidx, cidx+2));
            if(val >= 10 && val <= 26)
                counter += solve(str,cidx+2,dp);
        }
        
        dp[cidx] = counter;
        return dp[cidx];
    }
}