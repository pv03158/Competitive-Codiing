import java.util.Scanner; 

public class ArrayDS {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        //taking input of arrays
        for(int i=0;i<n;i++)
            arr[i] = scn.nextInt();

        // reversing array
        int lb = 0;
        int ub = n - 1;
        while(lb<ub) {
            int tmp = arr[lb];
            arr[lb] = arr[ub];
            arr[ub] = tmp;

            lb++;
            ub--;
        }

        // printing array
        for(int i=0;i<n;i++) 
            System.out.print(arr[i] + " ");
    }
}