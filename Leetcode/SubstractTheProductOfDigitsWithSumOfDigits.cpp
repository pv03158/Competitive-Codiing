class Solution {
public:
    int subtractProductAndSum(int n) {
        vector<int> arr;
        
        // REMOVING BITS FROM NUMBER N
        while(n > 0) {
            int bit = n % 10;
            arr.push_back(bit);
            n /= 10;
        }
        
        int product = 1, sum = 0;
        // FINDING THE PRODUCT & SUM OF BITS 
        for(int idx = 0 ; idx < arr.size() ; idx++) {
            int bit = arr[idx];
            product *= bit;
            sum += bit;
        }
        
        return product - sum;
    }
};