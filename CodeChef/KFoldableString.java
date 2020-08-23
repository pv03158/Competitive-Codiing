import java.util.*;

public class KFoldableString {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            scn.nextLine(); // to clear buffer
            String str = scn.nextLine();
            
            // counting number of 0's and 1's
            int zeroCounter = 0;
            int oneCounter = 0;
            for(int idx = 0 ; idx < str.length() ; idx++)
                if(str.charAt(idx) == '0')
                    zeroCounter++;
                else
                    oneCounter++;

            int factor = n / k;
            int length = n;
            // checking whether number can be folded to k length
            boolean flag = false;
            while(length != k) {
                if(length % 2 != 0) { 
                    flag = true;
                    break;
                }
                length = length / 2;
            }
            if(flag || zeroCounter % factor != 0 || oneCounter % factor != 0) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            StringBuilder ans = new StringBuilder();
            // when no folding takes place
            if(n == k) {
                for(int idx = 0 ; idx < zeroCounter / factor ; idx++)
                    ans.append("0");
                for(int idx = 0 ; idx < oneCounter / factor ; idx++)
                    ans.append("1");

                System.out.println(ans);
                continue;
            }

            for(int idx = 0 ; idx < oneCounter / factor ; idx++)
                ans.append("1");
            for(int idx = 0 ; idx < zeroCounter / factor ; idx++)
                ans.append("0");

            for(int iter = 0 ; k*(1<<iter) < n ; iter++ ) {
                StringBuilder rev = new StringBuilder(ans);
                rev.reverse();
                ans = rev.append(ans);
            }
            System.out.println(ans);
        }
        scn.close();
    }
}