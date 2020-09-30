class Solution {
public:
    int numberOfSteps (int num) {
        if(num == 0 || num == 1)
            return num;
        
        int counter = 0;
        if(num % 2 == 0) 
            counter += numberOfSteps(num / 2) + 1;
        else
            counter += numberOfSteps(num - 1) + 1;
        
        return counter;
    }
};