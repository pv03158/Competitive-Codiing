import java.util.*;

public class StringConstruction {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        printMaxDiverseString(n, k);
        scn.close();
    }

    public static void printMaxDiverseString(int n, int k) {
        char ch = 'a';
        String str = new String();

        if (k > 26) {
            for (int idx = 0; idx < k;) {
                if (ch == 'z' + 1)
                    ch = 'a';

                for (int iter = 0; iter < k - 26 && ch == 'a'; iter++) {
                    str += ch;
                    idx++;
                }
                str += ch;
                idx += 1;
                ch += 1;
            }
        }
        else {
            for (int idx = 0; idx < k; idx++) {
                if (ch == 'z' + 1)
                    ch = 'a';

                str += ch;
                ch += 1;
            }

            int multiplier = n / k;
            String res = new String();
            for (int iter = 0; iter < multiplier; iter++)
                res += str;
            System.out.println(res);
        }
        int multiplier = n / k;
        String res = new String();
        for (int iter = 0; iter < multiplier; iter++)
            res += str;
        System.out.println(res);
    }
}