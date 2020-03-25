// SYNOPSIS :-
// 1. TO PARSE ARRAY INTO STRING LIKE [1,2,3] WE USE Arrays.toString(array) method which presents in java.util.Arrays
// 2. ARRAYS ARE PASSED AS CALL BY REFERENCE VARIABLE IN JAVA


// PROBLEM :-
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.Scanner;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = scn.nextInt();
        int  target = scn.nextInt();
        System.out.println( Arrays.toString(twoSum(arr, target)) );
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean gotchaFlag = false;
        
        for (int i=0;i<nums.length;i++) {
            for ( int j=0;j<nums.length;j++ ) {
                if ( nums[i] + nums[j] == target && i != j ) {
                    result[0] = j;
                    result[1] = i;
                    gotchaFlag = true;
                    break;
                }
            }
            if (gotchaFlag)
                break;
        }  
        return result;
    }
}