import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t-- > 0) {
		    int n = scn.nextInt();
		    int diff = scn.nextInt();
		    int arr[] = new int[n];
		    for(int idx = 0 ; idx < n ; idx++)
		        arr[idx] = scn.nextInt();
		        
		    // ADDING VALUES IN HASHMAP
		    HashMap<Integer, Integer> hm = new HashMap<>();
		    for(int idx = 0 ; idx < n ; idx++)
		        hm.put(arr[idx], idx);
		        
		    boolean findFlag = false;
		    for(int idx = 0 ; idx < n && !findFlag ; idx++) 
		        if(hm.containsKey(arr[idx] - diff) && hm.get(arr[idx] - diff) != idx
		            || hm.containsKey(diff - arr[idx]) && hm.get(diff - arr[idx]) != idx)
		            findFlag = true;
		            
		    if(findFlag) System.out.println(1);
		    else System.out.println(-1);
		}
		
	}
}