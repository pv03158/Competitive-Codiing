class Solution {
    public int[] sortArrayByParity(int[] arr) {
        // USING TWO POINTER APPROACH TO SORT BY PARITY
        int startIdxOdd = 0;
        for(int ptr = 0 ; ptr < arr.length ; ptr++) 
            if(arr[ptr] % 2 == 0)
                swap(arr, startIdxOdd ++, ptr);
        
        return arr;
    }
    
    // METHOD TO SWAP TWO ELEMENTS IN ARRAY
    private void swap(int arr[], int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}