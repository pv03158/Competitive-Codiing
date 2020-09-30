class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        
        ans[0] = nums[0];
        for(int idx = 1 ; idx < n ; idx++)
            ans[idx] = ans[idx - 1] + nums[idx];
        
        return ans;
    }
};