class Solution {
public:
    int balancedStringSplit(string s) {
        int counter = 0;
        int state = 0;
        for(int idx = 0 ; idx < s.length() ; idx++) {
            if(s.at(idx) == 'R')
                state -= 1;
            else
                state += 1;
            
            if(state == 0)
                counter += 1;
        }
        
        return counter;
    }
};