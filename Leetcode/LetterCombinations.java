// PROBLEM - 17 LETTER COMBINATIONS OF A PHONE NUMBER

class Solution {
    
    public String[] keymap = { " ", ".;","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        
        if(digits.length() == 1) {
            List<String> base = new ArrayList<>();
            String keyval = keymap[Integer.valueOf(digits)];
            for(int idx = 0 ; idx < keyval.length() ; idx++)
                base.add(Character.toString(keyval.charAt(idx)));
            return base;
        }
        
        char ch = digits.charAt(0);
        String keyval = keymap[Character.getNumericValue(ch)];
        String qsf = digits.substring(1);
        List<String> res = new ArrayList<>();
        for(int idx = 0 ; idx < keyval.length() ; idx++) {
            // faith that if I pass the substring of digits string this function will returns me
            // the letter combination possible from that substring
            List<String> asf = letterCombinations(qsf);
            for(String str : asf)
                res.add(keyval.charAt(idx) + str);
        }
        return res;
    }
}