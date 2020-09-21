import java.util.*;

public class DigitGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- > 0) {
            int n = scn.nextInt();
            int even = 0;
            int odd = 0;

            scn.nextLine();
            String str = scn.nextLine();
            for(int idx = 0 ; idx < str.length() ; idx ++)  {
                int bit = Character.getNumericValue(str.charAt(idx));
                if( bit % 2 == 0) even += 1;
                else odd += 1;
            }

            if(even >= odd) System.out.println(2);
            else System.out.println(1);
        }

    }
}