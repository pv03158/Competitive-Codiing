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
    public List<Integer> preorderTraversal(TreeNode root) {
        // MANAGING CORNER CASES
        if(root == null) {
            List<Integer> base = new ArrayList<>();
            return base;
        }
        
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(stack.size() != 0) {
            TreeNode node = stack.pop();
            arr.add(node.val);
            
            // ADDING RIGHT-LEFT CHILDS, IF THEY EXISTS
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        
        return arr;
    }
}