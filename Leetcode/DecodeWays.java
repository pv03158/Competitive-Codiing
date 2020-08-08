class Solution {
    public int numDecodings(String str) {
        if(str.length() == 0)
            return 1;
        
        int counter = 0;
        if(str.length() >= 1) {
            int val = Integer.valueOf(str.substring(0,1));
            if(val == 0)
                return 0;
            if(val >= 1 && val <= 9)
                counter += numDecodings(str.substring(1));
        }
        if(str.length() >= 2) {
            int val = Integer.valueOf(str.substring(0,2));
            if(val == 0)
                return 0;
            if(val >= 10 && val <= 26)
                counter += numDecodings(str.substring(2));
        }
        return counter;
    }
}