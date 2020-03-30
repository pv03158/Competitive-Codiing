import java.util.Scanner ;
import java.util.Arrays;

public class ArrayManipulation3 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int col = scn.nextInt();
        int row = scn.nextInt();
        long arr[] = new long[col+1];
        
        // generating output alongside taking input
        for(int i=0;i<row;i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            int k = scn.nextInt();

            arr[a-1] += k;
            arr[b] += -k;
        }

        // finding finalised array
        long max = arr[0];
        for(int i=1;i<col;i++){
            arr[i] += arr[i-1];
            max = max>arr[i] ? max : arr[i];
        }
        System.out.println(max);
    }
}