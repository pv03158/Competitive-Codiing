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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivaluedTreeHelper(root, root.val);
    }
    
    private boolean isUnivaluedTreeHelper(TreeNode node, int data) {
        if(node == null)
            return true;
        else if(node.val == data)
            return isUnivaluedTreeHelper(node.left, data) 
            && isUnivaluedTreeHelper(node.right, data);
        else
            return false;
    }
}