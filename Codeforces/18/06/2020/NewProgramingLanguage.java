import java.util.*;

public class NewProgramingLanguage {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        while(t-- > 0) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            int n = scn.nextInt();

            int counter = 0;
            while( a <= n && b <= n ) {
                // considering a is always smaller in value then b
                if(a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }

                a += b;
                counter += 1;
            }
            System.out.println(counter);
        }
    }
}