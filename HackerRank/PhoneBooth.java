import java.util.Scanner;

public class PhoneBooth {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        int vacant = 0;
        for(int i=0;i<n;i++) {
            arr[i] = scn.nextInt();
            if(arr[i] == 0)
                vacant++;
        }

        int k = scn.nextInt();
        System.out.println(printPhoneBoothStatus(arr,vacant,k));
    }

    public static boolean printPhoneBoothStatus(int arr[],int vacant, int k) {
        if(k == 0) {
            return true;
        }

        if(k > arr.length || k >= vacant) {
            return false;
        }

        // placing peoples in phone booth
        boolean status = true;
        for(int i=0;i<arr.length;i++) {
            if(i==0 && arr[i+1] == 0) {
                arr[i] = 1;
                status = printPhoneBoothStatus(arr, vacant-1, k-1);
            }
            else if(i == arr.length-1 && arr[i-1] == 0) {
                arr[i] = 1;
                status = printPhoneBoothStatus(arr, vacant-1, k-1);
            }
            else if( i >=1 && i < arr.length-1 && arr[i-1] == 0 && arr[i+1] == 0) {
                arr[i] = 1;
                status = printPhoneBoothStatus(arr, vacant-1, k-1);
            }
            if(!status)
                return false;
        }
        return status;
    }
}