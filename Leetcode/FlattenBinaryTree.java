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
    public void flatten(TreeNode root) {
        flattenTheTree(root);
    }
    
    private TreeNode flattenTheTree(TreeNode node) {
        if(node == null)
            return null;
        
        TreeNode lc = flattenTheTree(node.left);
        TreeNode rc = flattenTheTree(node.right);
        
        if(lc == null && rc == null)
            return node;
        else if(lc == null) 
            return rc;
        else if(rc == null) {
            node.right = node.left;
            node.left = null;
            return lc;
        }
        else {
            lc.right = node.right;
            node.right = node.left;
            node.left = null;
            return rc;
        }
    }
}