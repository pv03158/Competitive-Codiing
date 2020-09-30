class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, 0);

        // DP[IDX] = NUMBER OF VALS IN NUMS WHICH IS
        // SMALLER THAN IDX
        vector<int> dp(105, 0);
        for(int idx = 0 ; idx < n ; idx++) {
            int bit = nums[idx];
            dp[bit + 1] += 1;
        }
        
        // GENERATING PREFIX SUM ARRAY
        for(int idx = 1 ; idx < dp.size() ; idx++)
            dp[idx] += dp[idx - 1];
        
        
        // PROCESSING OUTPUT
        for(int idx = 0 ; idx < n ; idx++)
            ans[idx] = dp[ nums[idx] ];
        
        return ans;
    }
};