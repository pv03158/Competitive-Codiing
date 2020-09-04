class Solution {
    public int longestValidParentheses(String str) {
        
        Stack<Integer> stack = new Stack<>();
        int blocker = -1;
        int maxlength = 0;
        
        for(int idx = 0 ; idx < str.length() ; idx++) {
            char ch = str.charAt(idx);
            // WHEN OPENING BRACKET ENCOUNTERS
            if(ch == '(') 
                stack.push(idx);
            // WHEN CLOSING BRACKET ENCOUNTERS
            else {
                // IF ITS COUNTER PART AVAILABLE
                if(stack.size() != 0)  {
                    stack.pop();
                    int lowerBound = (stack.size() != 0) 
                                        ? stack.peek() : blocker;
                    int length = idx - lowerBound;
                    maxlength = Math.max(maxlength, length);
                }
                // IF ITS COUNTER PART AREN'T AVAILABLE
                else 
                    blocker = idx;
            }
        }
        
        return maxlength;
    }
}