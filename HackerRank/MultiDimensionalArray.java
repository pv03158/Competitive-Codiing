import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    public static int sumOfSingleHourGlass(int[][] arr,int minR,int maxR,int minC,int maxC) {
        int sum = 0;
        for (int i=minC;i<=maxC;i++) {
            sum += arr[minR][i] + arr[maxR][i];
        }
        return sum + arr[(minR+maxR)/2][(minC+maxC)/2];
    }

    static int hourglassSum(int[][] arr) {
        int maxR = arr.length - 3;
        int maxC = arr[0].length - 3;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<=maxR;i++) {
            for(int j=0;j<=maxC;j++) {
                int sum = sumOfSingleHourGlass(arr,i,i+2,j,j+2);
                maxSum = maxSum > sum ? maxSum : sum;
            }
        }
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
