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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int preorder[], int inorder[], int plb, int pub, int ilb, int iub) {
        if(plb > pub || ilb > iub)
            return null;
        
        TreeNode root = new TreeNode(preorder[plb]);
        int rootpos = ilb;
        while(inorder[rootpos] != preorder[plb])
            rootpos++;
        
        int lcCount = rootpos - ilb;
        
        root.left = helper(preorder, inorder, plb + 1, plb + lcCount, ilb, rootpos - 1);
        root.right = helper(preorder, inorder, plb + lcCount + 1, pub, rootpos + 1, iub);
        return root;
    }
}