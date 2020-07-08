import java.util.*;

public class ChefAndStrings {
    public static void main(String args[])  {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            int arr[] = new int[n];
            // taking input
            for(int idx = 0 ; idx < n ; idx++) 
                arr[idx] = scn.nextInt();

            // processing output
            long counter = 0;
            for(int idx = 0; idx < n-1 ; idx++) {
                counter += Math.abs(arr[idx + 1] - arr[idx]) - 1;
            }
            // displaying output
            System.out.println(counter);
        }
        scn.close();
    }
}