// APPROACH -- 1 (Optimized approach)
class Solution {
    public int minAddToMakeValid(String S) {
        
        int cbr = 0, obr = 0;
        for(int idx = 0 ; idx < S.length() ; idx++) {
            char ch = S.charAt(idx);
            // CONDITION WHEN WE ENCOUNTER AN OPENING BRACKET
            if(ch == '(') 
                cbr += 1;
            // CONDITION WHEN WE ENCOUNTER A CLOSING BRACKET
            else {
                if(cbr != 0) cbr -= 1;
                else obr += 1;
            }
        }
        
        return obr + cbr;
    }
}


// APPROACH -- 2
class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        
        for(int idx = 0 ; idx < S.length() ; idx++) {
            char ch = S.charAt(idx);
            if(ch != ')' && ch != '}' && ch != ']')
                stack.push(ch);
            
            // CHECKING FOR ')'
            if(ch == ')') {
                while(stack.size() != 0 && stack.peek() != '(') {
                    counter += 1;
                    stack.pop();
                }
                if(stack.size() == 0) counter ++; 
                else stack.pop();
            }
            
            // CHECKING FOR '}'
            if(ch == '}') {
                while(stack.size() != 0 && stack.peek() != '{') {
                    counter += 1;
                    stack.pop();
                }
                if(stack.size() == 0) counter ++; 
                else stack.pop();
            }
            
            // CHECKING FOR ']'
            if(ch == ']') {
                while(stack.size() != 0 && stack.peek() != '[') {
                    counter += 1;
                    stack.pop();
                }
                if(stack.size() == 0) counter ++; 
                else stack.pop();
            }
        }
        
        // CHECKING WHETHER STACK CONTAINS UNPROCESSED ELEMENTS
        while(stack.size() != 0) {
            counter ++;
            stack.pop();
        }
        // RETURNING OUTPUT
        return counter;
    }
}