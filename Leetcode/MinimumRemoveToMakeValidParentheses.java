class Solution {
    public String minRemoveToMakeValid(String str) {
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> pos = new ArrayList<>(str.length());
        
        // STORING GIVEN STRING IN STRING BUILDER
        StringBuilder res = new StringBuilder(str);
    
        for(int idx = str.length() - 1 ; idx >= 0 ; idx--) {
            char ch = str.charAt(idx);
            if(ch == ')') stack.push(idx);
            else if (ch == '(') {
                // IF THEIRS ANY COUNTER-PART OF IT, THEN IT MUST BE ON TOP OF STACK
                if(stack.size() != 0) stack.pop();
                else res.setCharAt(idx, '#');
            }
        }
        
        while(stack.size() != 0) res.setCharAt(stack.pop(), '#');
        
        // REPLACING ALL '#' WITH ''
        return res.toString().replaceAll("#","");
    }
}