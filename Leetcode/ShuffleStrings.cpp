class Solution {
public:
    string restoreString(string s, vector<int>& indices) {
        string str(s.length(), ' ');
        for(int idx = 0 ; idx < s.length() ; idx++) {
            int pos = indices[idx];
            str[pos] = s.at(idx);
        }
        
        return str;
    }
};