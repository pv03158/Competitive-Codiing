class Solution {
    public int maximumSwap(int num) {
        
        String str = Integer.toString(num);
        int lastEncIdx[] = new int[10];
        Arrays.fill(lastEncIdx, -1);
        
        // FINDING LAST ENCOUNTER INDEX OF EACH BIT IN THE 
        // STRING OF NUMBER
        for(int idx = str.length() - 1 ; idx >= 0 ; idx--) {
            int bit = Character.getNumericValue(str.charAt(idx));
            if(lastEncIdx[bit] == -1 )
                lastEncIdx[bit] = idx;
        }
        
        // SWAPPING THE HIGHEST PLACE VALUE BITS WITH
        // GREATER VALUE BIT FROM THE LEAST SIGNIFICANT INDEX
        for(int idx = 0 ; idx < str.length() ; idx++) {
            int bit = Character.getNumericValue(str.charAt(idx));
            boolean breakFlag = false;
            for(int ptr = 9 ; ptr > bit ; ptr--) {
                if(lastEncIdx[ptr] != -1 && lastEncIdx[ptr] > idx) {
                    str = swap(str, lastEncIdx[ptr], idx);
                    breakFlag = true;
                    break;
                }
            }
            if(breakFlag) break;
        }
        
        return Integer.valueOf(str);
    }
    
    private String swap(String str, int idx1, int idx2) {
        StringBuilder ans = new StringBuilder(str);
        char ch = ans.charAt(idx1);
        ans.setCharAt(idx1, ans.charAt(idx2));
        ans.setCharAt(idx2, ch);
        
        return ans.toString();
    }
}