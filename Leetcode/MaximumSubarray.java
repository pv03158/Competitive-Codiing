class Solution {
    public int maxSubArray(int[] nums) {
        // MANAGING CORNER CASES
        if(nums.length == 1)
            return nums[0];
        
        int ans = getMaxSum(nums);
        // int ans = getMaxSum(nums, 0, nums.length - 1);
        return ans;
    }
    
    // KADANE'S SOLUTION O(N)
    public int getMaxSum(int[] arr) {
        int maxsf = arr[0];
        int sum = 0;
        
        for(int idx = 0 ; idx < arr.length ; idx++) {
            sum += arr[idx];
            maxsf = Math.max(maxsf, sum);
            sum = (sum < 0) ? 0 : sum;
        }
        
        return maxsf;
    }
    
    // DIVIDE AND CONQUER APPROACH
    private int getMaxSum(int[] arr, int lb, int ub) {
        return 0;
    }
    
}