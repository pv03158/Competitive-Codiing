class Solution {
    
    public int nextGreaterElement(int n) {    
        // PARSING THE GIVEN NUMBER INTO STRING
        String str = Integer.toString(n);
        if(str.length() == 1)
            return -1;
        
        int ptr = str.length() - 2;
        while(ptr >= 0 && str.charAt(ptr) >=str.charAt(ptr+1))
              ptr -= 1;
              
        if(ptr == -1)
              return -1;
        
        str = reverse(str,ptr + 1, str.length() - 1);
        for(int idx = ptr + 1; idx < str.length() ; idx++) {
            if(str.charAt(ptr) < str.charAt(idx)) {
                str = swap(str, ptr,idx);
                break;
            }
        }
        
        int ans = -1;
        try {
            // CHECKING FOR INTEGER OUT OF RANGE EXCEPTION AFTER
            // CHANGING BITS
            ans = Integer.valueOf(str);
        }
        catch(Exception e) {
            // WHEN THE FINAL STRING STR VALUE BECOMES GREATER THAN 
            // INTEGER.MAX_VALUE
            ans = -1;
        }
        
        return ans;
    }
              
    private String reverse(String str, int lb, int ub) {
        StringBuilder ans = new StringBuilder(str);
        while(lb < ub) {
            char ch = str.charAt(lb);
            ans.setCharAt(lb, str.charAt(ub));
            ans.setCharAt(ub, ch);
            
            lb += 1;
            ub -= 1;
        }
        
        return ans.toString();
    }
              
    private String swap(String str, int ptr1, int ptr2) {
        StringBuilder ans = new StringBuilder(str);
        char ch = str.charAt(ptr1);
        ans.setCharAt(ptr1, str.charAt(ptr2));
        ans.setCharAt(ptr2, ch);
        
        return ans.toString();
    }
}