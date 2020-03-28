import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    public static long arrayManipulation(int n, int[][] queries) {
        long max = Integer.MIN_VALUE;
        long[][] arr = new long[queries.length][n];
        for(int i=0;i<queries.length;i++){
            
            // updating matrix value with preceeded row values
            for(int j=0;j<n;j++) {
                if(i!=0)
                    arr[i][j] = arr[i-1][j];
                max = (max<arr[i][j]) ? arr[i][j] : max;
            }

            // updating value of each row with k
            for(int c=queries[i][0]-1;c<=queries[i][1]-1;c++){
                arr[i][c] = arr[i][c] + queries[i][2];
                max = (max<arr[i][c]) ? arr[i][c] : max;
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

        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }
}
