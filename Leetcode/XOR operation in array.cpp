class Solution {
public:
    int xorOperation(int n, int start) {
        int res = 0 ;
        for(int iter = 0 ; iter < n ; iter ++) 
            res = (res ^ (start + 2*iter));
        
        return res;
    }
};