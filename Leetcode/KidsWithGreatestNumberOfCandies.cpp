class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int n = candies.size();
        vector<bool> ans(n);
        
        int maxcount = INT_MIN;
        for(int val : candies)
            maxcount = max(maxcount, val);
        
        for(int idx = 0 ; idx < n ; idx++)
            ans[idx] = candies[idx] + extraCandies >= maxcount ? true : false;
        
        return ans;
    }
};