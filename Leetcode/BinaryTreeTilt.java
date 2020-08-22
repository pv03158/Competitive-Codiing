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
    
    public class TSPair {
        int tilt;
        int sum;
        
        TSPair(int tilt, int sum) {
            this.tilt = tilt;
            this.sum = sum;
        }
    }
    
    public int findTilt(TreeNode root) {
        return findTiltHelper(root).tilt;    
    }
    
    public TSPair findTiltHelper(TreeNode node) {
        if(node == null)
            return new TSPair(0,0);
        
        TSPair left = findTiltHelper(node.left);
        TSPair right = findTiltHelper(node.right);
        return new TSPair(left.tilt + right.tilt + Math.abs(left.sum - right.sum),
                         left.sum + right.sum + node.val);
    }
}