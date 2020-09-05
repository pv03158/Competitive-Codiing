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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            List<Integer> base = new ArrayList<>();
            return base;
        }
        
        List<Integer> arr = new ArrayList<>();
        Stack<Pair<TreeNode>> stack = new Stack<>();
        stack.push(new Pair<TreeNode>(0, root));
        
        while(stack.size() != 0) {
            Pair<TreeNode> ele = stack.pop();
            // EXECUTES WHEN THE ELEMENT IS TRAVERSED FIRST TIME
            if(ele.state == 0) {
                if(ele.node.right != null)
                    stack.push(new Pair<TreeNode>(0, ele.node.right));
                
                ele.state += 1;
                stack.push(ele);
                
                if(ele.node.left != null)
                    stack.push(new Pair<TreeNode>(0, ele.node.left));
            }
            // EXECUTES WHEN THE ELEMENT IS TRAVERSED SECOND TIME
            else if(ele.state == 1) {
                arr.add(ele.node.val);
                ele.state += 1;
            }
        }
        
        return arr;
    }
    
    private class Pair <Type> {
        int state;
        Type node;
        
        Pair(int state, Type node) {
            this.state = state;
            this.node = node;
        }
    }
}