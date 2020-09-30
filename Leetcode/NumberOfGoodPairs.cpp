class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        int n = nums.size();
        int dp[105] = { 0 };    // THIS DP STORES NUMBER OF OCCURENCE OF 
                                // A BIT
        int counter = 0;
        for(int idx = 0 ; idx < n ; idx++) {
            int bit = nums[idx];
            counter += dp[bit] ;
            dp[bit] += 1;
        }
        
        return counter;
    }
};