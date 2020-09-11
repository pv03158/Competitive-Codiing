class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        // MANAGING CORNER CASES
        if(length == 0 || length == 1)
            return;
        
        // GETTING ABSOLUTE VALUE OF K TO REDUCE
        // NUMBER OF REPETITIVE ITERATIONS
        k = k % length;
        
        reverse(nums, 0, length - k -1);
        reverse(nums, length - k, length - 1);
        reverse(nums, 0, length - 1);
    }
    
    private void reverse(int arr[], int lb, int ub) {
        // USING TWO POINTER APPROACH TO REVERSE AN ARRAY
        while(lb < ub) {
            int tmp = arr[lb];
            arr[lb++] = arr[ub];
            arr[ub--] = tmp;
        }
    }
}