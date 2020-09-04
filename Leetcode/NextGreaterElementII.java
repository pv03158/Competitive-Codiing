class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);
        
        for(int iter = 0 ; iter < 2*nums.length ; iter++) {
            int idx = iter % nums.length;
            while(stack.size() != 0 && nums[stack.peek()] < nums[idx])
                ans[stack.pop()] = nums[idx];
            
            stack.push(idx);
        }
        
        return ans;
    }
}