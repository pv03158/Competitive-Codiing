import java.util.*;

public class StringSimilarity {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- > 0) {
            int n = scn.nextInt();
            scn.nextLine();
            String str = scn.nextLine();
            String ans = "";
            for(int idx = 0 ; idx < str.length() ; idx += 2) {
                char ch = str.charAt(idx);
                ans += ch;
            }
            
            // displaying output
            System.out.println(ans);
        }
    }
}