class Solution {
public:
    string defangIPaddr(string address) {
        string ans;
        for(int idx = 0 ; idx < address.length() ; idx ++) {
            char ch = address.at(idx);
            if(ch != '.')
                ans.push_back(ch);
            else 
                ans.append("[.]");
        }
        
        return ans;
    }
};