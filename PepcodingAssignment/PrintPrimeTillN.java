import java.util.*;

public class PrintPrimeTillN {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean notPrimeArr[] = new boolean[n + 1];

        for(int idx = 0 ; idx * idx <= n ; idx++) {
            if(idx == 0 || idx == 1)
                notPrimeArr[idx] = true;

            // HENCE ONLY THOSE INDEXES ARE MARKED FALSE, WHICH ARE PRIME
            // SO, IF AN IDX IS FALSE, THEN WE CAN ELEMINATE ALL ITS FACTOR
            // FROM DP OF NOT PRIMES BY MARKING THEM TRUE
            else if( ! notPrimeArr[idx] )
                for(int factor = 2 ; factor <= n / idx ; factor ++) 
                    notPrimeArr[idx * factor] = true;
        }

        // PRINTING RESULT TO THE USER
        for(int idx = 0 ; idx < n + 1 ; idx++) 
            if( ! notPrimeArr[idx] )
                System.out.print(idx + " ");
        System.out.println();
    }
}
