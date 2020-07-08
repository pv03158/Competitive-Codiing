import java.util.*;

public class MaxPositiveSubArray {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            // taking input
            int n = scn.nextInt();
            int arr[] = new int[n];
            for(int idx = 0 ; idx < n ; idx++) 
                arr[idx] = scn.nextInt();

            // processing output
            ArrayList <Integer> arrlist = new ArrayList<>();
            ArrayList <Integer> tmp = new ArrayList<>();
            int maxsum = 0;
            int cursum = 0;
            
            for(int idx = 0 ; idx < n ; idx++) {
                if(arr[idx] >= 0)  {
                    tmp.add(arr[idx]);
                    cursum += arr[idx];
                }
                else {
                    if( tmp.size() != 0 && maxsum <= cursum ) {
                        arrlist = tmp;
                        maxsum = cursum;
                    }

                    tmp = new ArrayList<>();
                    cursum = 0;
                }
            }

            // safety check, when all elements in array are positive
            if( tmp.size() != 0 && maxsum <= cursum )
                arrlist = tmp;

            // showing output
            for(int idx = 0 ; idx < arrlist.size() ; idx++)
                System.out.print(arrlist.get(idx) + " ");
            System.out.println();
        }
        scn.close();
    }
}