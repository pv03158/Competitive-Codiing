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
    public int movescount = 0;
    
    public int distributeCoins(TreeNode root) {
        Pair scPair = getNodeSum(root);
        int perNodeCoins = scPair.sum / scPair.counter;
        
        distributeCoinsHelper(root, perNodeCoins);
        return movescount;
    }
    
    // returns number of coins required to balance the tree
    private int distributeCoinsHelper(TreeNode node, int perNodeCoins) {
        if(node == null)
            return 0;
        
        int leftReq = distributeCoinsHelper(node.left, perNodeCoins);
        int rightReq = distributeCoinsHelper(node.right, perNodeCoins);
        
        movescount += Math.abs(leftReq) + Math.abs(rightReq);
        return leftReq + rightReq + node.val - perNodeCoins;
    }
    
    private Pair getNodeSum(TreeNode node) {
        if(node == null)
            return new Pair(0,0);
        
        Pair left = getNodeSum(node.left);
        Pair right = getNodeSum(node.right);
        return new Pair( left.counter + right.counter + 1,
                        left.sum + right.sum + node.val );
    }
    
    private class Pair {
        int counter;
        int sum;
        
        Pair(int counter , int sum) {
            this.counter = counter;
            this.sum = sum;
        }
    }
}