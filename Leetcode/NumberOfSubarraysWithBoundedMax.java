class Solution {
    public int numSubarrayBoundedMax(int[] arr, int L, int R) {
        
        int i = 0, j = 0 , counter = 0, localCounter = 0;
        for( ; j < arr.length ; j++ ) {
            if(arr[j] >= L && arr[j] <= R) {
                localCounter = j - i + 1;
                counter += localCounter;
            }
            // HENCE, ELEMENT IS SMALLER THAN L, ITS SINGLY 
            // NOT SUFFICIENT TO FULLFILL THE CONDITION
            else if(arr[j] < L)
                counter += localCounter;
            
            // IF THE ELEMENT ENCOUNTER IS GREATER THAN R,
            // MEANS ITS A SEPERATOR AND J+1 ACTS AS ANOTHER
            // INDEPENDENT ARRAY
            else if(arr[j] > R) {
                i = j + 1;
                localCounter = 0;
            }
        }
        
        return counter;
    }
}