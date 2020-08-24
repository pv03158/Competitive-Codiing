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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> opQueue = new ArrayDeque<>();
        opQueue.add(new Pair(root, 1));
        
        int width = 1;
        while(opQueue.size() != 0) {
            int size = opQueue.size();
            Pair sPair = opQueue.peek();
            Pair ePair = null;
            
            for(int iter = 0 ; iter < size ; iter++) {
                ePair = opQueue.remove();
                if(ePair.node.left != null)
                    opQueue.add(new Pair(ePair.node.left, 2*ePair.idx));
                if(ePair.node.right != null)
                    opQueue.add(new Pair(ePair.node.right, 2*ePair.idx + 1));
            }
            width = Math.max(width, ePair.idx - sPair.idx + 1);
        }
        return width;
    }
    private class Pair {
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
}