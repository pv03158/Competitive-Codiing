/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t-- > 0) {
		    // TAKING INPUT FROM USER
		    int n = scn.nextInt();
		    int arr[] = new int[n];
		    for(int idx = 0 ; idx < n ; idx++)
		        arr[idx] = scn.nextInt();
		        
		    // USING TWO POINTERS APPROACH TO SORT ARRAY
		    int zeroEndIdx = -1, twoStartIdx = arr.length;
		    int ptr = 0;
		    while (ptr < twoStartIdx) {
		        if(arr[ptr] == 0)
		            swap(arr, ++zeroEndIdx, ptr++);
		        else if(arr[ptr] == 2) 
		            swap(arr, --twoStartIdx, ptr);
		        else 
		            ptr += 1;
		    }
		    
		    // DISPLAYING OUTPUT
		    for(int idx = 0 ; idx < n ; idx++)
		        System.out.print(arr[idx] + " ");
		    System.out.println();
		}
	}
	
	private static void swap(int arr[], int idx1, int idx2) {
	    int tmp = arr[idx1];
	    arr[idx1] = arr[idx2];
	    arr[idx2] = tmp;
	}	
}