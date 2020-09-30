class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int counter = 0;
        unordered_map<char, bool> hm;
        for(int idx = 0 ; idx < J.length(); idx++)
            hm.insert({ J.at(idx), true });
        
        for(int idx = 0 ; idx < S.length(); idx++)
            if( hm.find(S.at(idx)) != hm.end()  )
                counter += 1;
        
        return counter;
    }
};