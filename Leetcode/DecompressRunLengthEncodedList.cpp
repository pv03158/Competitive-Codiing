class Solution {
public:
    vector<int> decompressRLElist(vector<int>& nums) {
        vector<int> arr;
        for(int idx = 0 ; idx < nums.size() ; idx += 2) {
            int freq = nums[idx];
            int val = nums[idx + 1];
            
            while(freq --) 
                arr.push_back(val);
        }
        
        return arr;
    }
};