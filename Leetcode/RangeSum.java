public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int arr[] = new int[length];
        int k = updates.length;
        
        for(int idx = 0 ; idx < k ; idx++) {
            int st = updates[idx][0];
            int end = updates[idx][1];
            int val = updates[idx][2];
            
            arr[st] += val;
            if(end + 1 < length) 
                arr[end + 1] += -val;
        }
        
        for(int idx = 1 ; idx < length ; idx++)
            arr[idx] += arr[idx - 1];
            
        return arr;
        
    }
}