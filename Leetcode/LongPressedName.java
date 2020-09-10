class Solution {
    public boolean isLongPressedName(String name, String typed) {
        // USING TWO POINTER APPROACH TO FIND THE SOLUTION
        int i = 0, j = 0;
        while(i < typed.length() && j <= name.length() ) {
            
            if(j < name.length() && typed.charAt(i) == name.charAt(j)) {
                i += 1;
                j += 1;
            }
            else if( i > 0 && typed.charAt(i) == typed.charAt(i-1) )
                i += 1;
            else 
                return false;
        }
        
        if(i < typed.length() || j < name.length()) 
            return false;
        else
            return true;
    }
}