// LEETCODE PROBLEM : 46 PERMUTATIONS
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = getPermutations(nums);
        return permutations;
    }
    
    public List<List<Integer>> getPermutations(int nums[]) {
        if(nums.length == 1) {
            List<List<Integer>> base = new ArrayList<>();
            List<Integer> subbase = new ArrayList<>();
            subbase.add(nums[0]);
            base.add(subbase);
            return base;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int idx = 0 ; idx < nums.length ; idx++) {
            int num = nums[idx];
            // creating subarray of elements excluding element at idx
            int subarr[] = new int[nums.length - 1];
            int pos = 0;
            for(int iter = 0 ; iter < nums.length ; iter++) 
                if(iter != idx)
                    subarr[pos++] = nums[iter];
            // faith
            List<List<Integer>> asf = getPermutations(subarr);
            // pushing number in answer so far obtained from faith
            for(List<Integer> list : asf) {
                list.add(0,num);
                res.add(list);
            }
        }
        return res;
    }   
}