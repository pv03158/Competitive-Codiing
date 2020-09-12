import java.util.*;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if( n <= 0 || n == 1 ) {
            System.out.println("Not Prime");
            return;
        }

        for(int factor = 2 ; factor * factor <= n ; factor++) {
            if(n % factor == 0) {
                System.out.println("Not Prime");
                return;
            }
        }

        System.out.println("Prime");
    }
}
