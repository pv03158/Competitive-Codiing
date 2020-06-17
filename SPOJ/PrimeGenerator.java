import java.util.*;

public class PrimeGenerator {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        // int dp[] = new int[1000000001];
        // dp[0] = dp[1] = -1;

        while(t-- > 0) {
            int m = scn.nextInt();
            int n = scn.nextInt();
            for(int idx=m ; idx <= n ; idx++) {
                // APPROACH -- 1 WITH DYNAMIC PROGRAMMING
                // if( dp[idx] == 1 )
                //     System.out.println(idx);

                // else if( dp[idx] == 0 ) {
                //     boolean isNumPrime = isPrime(idx);
                //     if( isNumPrime ) {
                //         dp[idx] = 1;
                //         System.out.println(idx);
                //     }
                //     else {
                //         dp[idx] = -1;
                //     }  
                // }
                
                // APPROACH -- 2 WITHOUT DYNAMIC PROGRAMMING
                if( isPrime(idx) )
                    System.out.println(idx);
            }
            System.out.println();
        }
    }

    public static boolean isPrime(int num) {
        if(num == 0 || num == 1)
            return false;

        for(int idx=2; idx*idx <= num ; idx++) {
            if(num % idx == 0)
                return false;
        }
        return true;
    }
}