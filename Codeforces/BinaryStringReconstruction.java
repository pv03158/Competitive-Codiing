import java.util.*;

public class BinaryStringReconstruction {
    public static void main(String[] arg) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();

        while(t-- > 0) {
            String str = scn.nextLine();
            StringBuilder ans = new StringBuilder();
            for(int idx = 0 ; idx <= str.length(); idx++)
                ans.append("2");

            int x = scn.nextInt();
            int n = str.length();
            for(int i = 0 ; i < str.length() ; i++) {
                char ch = str.charAt(i);
                if( i > x && ch == '1' )
                    ans.setCharAt(i - x, '1');

                else if( i + x <= n && ch == '1')
                    ans.setCharAt(i + x, '1');
                else 
                    ans.setCharAt(index, ch);
            }

            ans.setCharAt(0, ans.charAt(ans.length() - 1));
            ans.delete(ans.length() - 1, ans.length());
            System.out.println(ans.toString());
        }
    }
}