import java.io.*;
import java.util.*;

public class temporary{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int d = scn.nextInt();
    int pos = -1;
    for(int i=0;i<arr.length;i++) {
        if(arr[i] == d){
            pos = i;   
        }
    }
    System.out.print(pos);
 }

}