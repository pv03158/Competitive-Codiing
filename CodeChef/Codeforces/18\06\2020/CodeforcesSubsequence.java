import java.util.*;

public class CodeforcesSubsequence {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();

        int counter = 0;
        long multiplier = 1;
        while(multiplier < n) {
            multiplier *= 2;
            counter ++;
        }
        // System.out.println(counter);
        
        int quotient = counter / 10;
        int rem = counter % 10;
        String str = "codeforces";
        String out = "";
        for(int idx=0 ;idx < str.length() ; idx++) {
            int repeationcount = quotient;
            if(rem-- > 0) 
                repeationcount += 1;
            while(repeationcount-- >= 0) {
                out += str.charAt(idx);
            }
        }

        System.out.println(out);
    }
}