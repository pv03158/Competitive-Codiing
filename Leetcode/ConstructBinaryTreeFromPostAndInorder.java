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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0,
                    inorder.length - 1, 0, postorder.length - 1 );
    }
    
    private TreeNode helper(int inorder[], int postorder[], int ilb,
                            int iub, int plb, int pub) {
        if(ilb > iub || plb > pub)
            return null;
        
        TreeNode root = new TreeNode(postorder[pub]);
        int rootpos = ilb;
        while( inorder[rootpos] != postorder[pub] )
            rootpos++;
        
        int lcCount = rootpos - ilb;
        root.left = helper(inorder, postorder,
                           ilb, rootpos - 1,
                           plb, plb + lcCount - 1);
        root.right = helper(inorder, postorder,
                            rootpos + 1, iub,
                            plb + lcCount, pub - 1);
        return root;
    }
}