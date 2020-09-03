class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int idx = 0 ; idx < s.length() ; idx++) {
            char ch = s.charAt(idx);
            if(ch == '(' || ch == '{' || ch == '[' )
                stack.push(ch);
            
            if(ch == ')' && (stack.size() == 0 || stack.pop() != '(')
              || ch == '}' && (stack.size() == 0 || stack.pop() != '{')
              || ch == ']' && (stack.size() == 0 || stack.pop() != '['))
                return false;
        }
        
        return stack.size() == 0;
    }
}