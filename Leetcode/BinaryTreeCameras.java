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
    private int cameraCounter = 0;
    public int minCameraCover(TreeNode root) {
        helper(root, null);
        return cameraCounter;
    }
    
    private void helper(TreeNode node, TreeNode parent) {
        // handling base conditions
        if(node == null)
            return;
        if(node.left == node.right && parent == null) {
            cameraCounter += 1;
            node.val = 1;
            return;
        }
        if(node.left == node.right && parent != null ) {
            if(parent.val != 1) {
                cameraCounter += 1;
                parent.val = 1;
            }
            return;
        }
        
        
        helper(node.left, node);
        helper(node.right, node);
        if(node.val == 1 || node.left != null && node.left.val == 1 
           || node.right != null && node.right.val == 1
           || parent != null && parent.val == 1)
            return;
        
        else {
            if(parent != null && parent.val != 1) {
                parent.val = 1;
                cameraCounter += 1;
            }
            else {
                node.val = 1;
                cameraCounter ++;
            }
            return;
        }
        
    }
}