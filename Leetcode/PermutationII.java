// PROBLEM - 47 PERMUTATIONS - II
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = getPermutations(nums, new boolean[nums.length], 0);
        return ans;
    }
    
    public List<List<Integer>> getPermutations(int nums[], boolean marked[],int counter) {
        if(counter == marked.length - 1) {
            List<List<Integer>> base = new ArrayList<>();
            List<Integer> subbase = new ArrayList<>();
            for(int idx = 0 ; idx < nums.length ; idx++) 
                if( !marked[idx] )
                    subbase.add(nums[idx]);
            base.add(subbase);
            return base;
        }
        
        
        HashMap<Integer, Boolean> visited = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for(int idx = 0 ; idx < nums.length ; idx++) {
            int num = nums[idx];
            if( !visited.containsKey(num) && !marked[idx] ) {
                visited.put(num,true);
                marked[idx] = true;
                List<List<Integer>> asf = getPermutations(nums, marked, counter+1);
                for(List<Integer> list : asf) {
                    list.add(0, num);
                    res.add(list);
                }
                marked[idx] = false;
            }
        }
        
        return res;
    }
}