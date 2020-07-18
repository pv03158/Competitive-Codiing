import java.util.*;

public class GroovingMonkeys {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            // taking input from cli
            int n = scn.nextInt();
            int arr[] = new int[n];
            for(int idx = 0 ; idx < n ; idx++) 
                arr[idx] = scn.nextInt() - 1;

            // processing output
            boolean flag = false;
            int currentPattern[] = new int[n];
            for(int idx = 0 ; idx < n ; idx++)
                currentPattern[idx] = idx;

            int counter = 0;
            while(!flag) {
                int newPattern[] = changePattern(currentPattern, arr);
                boolean isOriginalFormationRecovered = true;
                for(int idx = 0 ; idx <  n ; idx++)
                    if( newPattern[idx] != idx )
                        isOriginalFormationRecovered = false;

                flag = isOriginalFormationRecovered;
                currentPattern = newPattern;
                counter += 1;
            }

            // displaying output
            System.out.println(counter);
        }
    }

    public static int[] changePattern(int currentPattern[], int formulae[]) {
        int newPattern[] = new int[currentPattern.length];
        for(int idx = 0 ; idx < newPattern.length ; idx++) 
            newPattern[ formulae[idx] ] = currentPattern[idx];
        return newPattern;
    }
}