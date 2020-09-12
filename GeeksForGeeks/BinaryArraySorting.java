/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {	    
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t-- > 0) {
		    int n = scn.nextInt();
		    int arr[] = new int[n];
		    for(int idx = 0 ; idx < n ; idx++)
		        arr[idx] = scn.nextInt();
		        
		    // SORTING O'S & 1'S IN O(N) TIME COMPLEXITY
		    int zeroLastIdx = -1;
		    for(int ptr = 0 ; ptr < arr.length ; ptr++) {
		        if(arr[ptr] == 0) {
		            int tmp = arr[++zeroLastIdx];
	                arr[zeroLastIdx] = arr[ptr];
	                arr[ptr] = tmp;
		        }
		    }
		            
		    // DISPLAYING OUTPUT
		    for(int idx = 0 ; idx < arr.length ; idx++)
		        System.out.print(arr[idx] + " ");
		    System.out.println();
		}
	}
}