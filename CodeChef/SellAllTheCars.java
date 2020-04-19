// PROBLEM NAME : SELL ALL THE CARS

import java.util.*;

public class SellAllTheCars {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            int p[] = new int[n];
            for(int idx=0;idx<n;idx++) 
                p[idx] = scn.nextInt();

            // sorting array in ascending order
            Arrays.sort(p);
            // reversing array to get descending order
            for(int idx=0;idx<n/2;idx++) {
                int tmp = p[idx];
                p[idx] = p[n-1-idx];
                p[n-1-idx] = tmp;
            }
            // calculating profit
            long profit = 0;
            for(int idx=0;idx<n;idx++) {
                profit += p[idx] - idx > 0  ? p[idx] - idx : 0;
                profit %= 1000000007;
            }
            System.out.println(profit);
        }
    }
}