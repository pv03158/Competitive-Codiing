import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    public static long arrayManipulation(int n, int[][] queries) {
        long max = Integer.MIN_VALUE;
        long[] arr = new long[n];
        for(int i=0;i<queries.length;i++){
            
            // updating value of each row with k
            for(int c=queries[i][0]-1;c<=queries[i][1]-1;c++){
                arr[c] = arr[c] + queries[i][2];
                max = (max<arr[c]) ? arr[c] : max;
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                queries[i][j] = scn.nextInt();
            }
        }
        System.out.println(arrayManipulation(n, queries));
    }
}
