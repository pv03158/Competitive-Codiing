import java.util.Scanner;
import java.lang.Math;

public class abn{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        int[] a = new int[500];
        int[] b = new int[500];
        int[] n = new int[500];
        for( int i = 0; i < q ; i++ ){
            a[i] = input.nextInt();
            b[i] = input.nextInt();
            n[i] = input.nextInt();
        }
        // printing required output
        for ( int i = 0 ; i < q ; i++ ){
            int sum = 0;
            for( int j = 0 ; j <= n[i] - 1 ; j++ ){
                sum += b[i] * (int) Math.pow(2,j);
                System.out.printf("%d ", ( a[i] + sum ));
            }
            if ( i != q-1)
                System.out.println();
        }
        input.close();
    }
}