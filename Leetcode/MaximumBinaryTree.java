/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructBTreeHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructBTreeHelper(int arr[], int lb, int ub) {
        if(lb > ub)
            return null;
        
        if(lb == ub)
            return new TreeNode(arr[lb]);
        
        int maxpos = lb;
        for(int idx = lb + 1 ; idx <= ub ; idx++) 
            if(arr[idx] > arr[maxpos])
                maxpos = idx;
        
        TreeNode root = new TreeNode(arr[maxpos]);
        root.left = constructBTreeHelper(arr, lb , maxpos - 1);
        root.right = constructBTreeHelper(arr, maxpos + 1, ub);
        return root;
    }
}