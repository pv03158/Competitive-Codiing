class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int> ans( n << 1);
        
        for(int idx = 0 ; idx < n ; idx++) {
            ans[idx << 1] = nums[idx] ;
            ans[(idx << 1) + 1] = nums[idx + n];
        }
        
        return ans;
    }
};