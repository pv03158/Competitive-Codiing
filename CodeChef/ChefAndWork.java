import java.util.*;

public class ChefAndWork {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {

            int n = scn.nextInt();
            int k = scn.nextInt();
            int arr[] = new int[n];
            for(int idx = 0 ; idx < n ; idx++) 
                arr[idx] = scn.nextInt();

            // sliding window algorithm
            int i = 0 , j = 0;
            int counter = 0;
            int sum = 0;
            while( i < n && j < n ) {
                if( i == j) {
                    if(arr[i] > k) {
                        counter = -1;
                        break;
                    }
                    sum += arr[i];
                    j += 1;
                }
                else if( sum + arr[j] > k) {
                    counter ++;
                    sum = 0;
                    i = j;
                }
                else {
                    sum += arr[j];
                    j++;
                }
            }
            if(sum > 0)
                counter ++;
                
            System.out.println(counter);
        }

        scn.close();
    }
}