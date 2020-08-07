// LEETCODE PROBLEM : 46 PERMUTATIONS
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = getPermutations_02(nums, new boolean[nums.length], 0);
        return permutations;
    }

    public List<List<Integer>> getPermutations_01(int nums[]) {
        if (nums.length == 1) {
            List<List<Integer>> base = new ArrayList<>();
            List<Integer> subbase = new ArrayList<>();
            subbase.add(nums[0]);
            base.add(subbase);
            return base;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];
            // creating subarray of elements excluding element at idx
            int subarr[] = new int[nums.length - 1];
            int pos = 0;
            for (int iter = 0; iter < nums.length; iter++)
                if (iter != idx)
                    subarr[pos++] = nums[iter];
            // faith
            List<List<Integer>> asf = getPermutations(subarr);
            // pushing number in answer so far obtained from faith
            for (List<Integer> list : asf) {
                list.add(0, num);
                res.add(list);
            }
        }
        return res;
    }

    // SECOND APPROACH OF SOLVING PROBLEM BY ELIMINATING THE NEW ARRAY CREATION DURING EACH 
    // RECURSIVE CALL TO THE FUNCTION
    public List<List<Integer>> getPermutations_02(int nums[], boolean visited[], int counter) {
        if(counter == visited.length - 1) {
            List<List<Integer>> base = new ArrayList<>();
            List<Integer> subbase = new ArrayList<>();
            for(int idx = 0 ; idx < nums.length ; idx++)
                if( !visited[idx] )
                    subbase.add(nums[idx]);
            base.add(subbase);
            return base;
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int idx = 0 ; idx < nums.length ; idx++) {
            if( !visited[idx] ) {
                visited[idx] = true;
                int num = nums[idx];
                List<List<Integer>> asf = getPermutations_02(nums, visited, counter + 1);
                for(List<Integer> list : asf) {
                    list.add(0,num);
                    res.add(list);
                }
                visited[idx] = false;
            }
        }
        return res;
    }
}