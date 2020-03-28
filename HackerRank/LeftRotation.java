import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scn.nextInt();

        // finding absolute rotation number
        r = r%arr.length;
        r = (r<0) ? arr.length+r : r;

        // reversing arr from 0 to r
        reverse(arr,0,r-1);
        reverse(arr,r,arr.length-1);
        reverse(arr,0,arr.length-1);

        for(int val:arr) {
            System.out.print(val + " ");
        }

    }
    public static void reverse(int arr[],int start, int end) {
        while(start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;

            start++;
            end--;
        }
    }
}