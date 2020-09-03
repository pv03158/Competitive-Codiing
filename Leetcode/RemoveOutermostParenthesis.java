class Solution {
    public String removeOuterParentheses(String S) {
        
        int state = 0;
        StringBuilder ans = new StringBuilder();
        for(int idx = 0 ; idx < S.length() ; idx++) {
            char ch = S.charAt(idx);
            if(state == 0 && ch == '(')
                state -= 1;
            else if(state == -1 && ch == ')')
                state += 1;
            else {
                state += (ch == '(') ? -1 : 1;
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}