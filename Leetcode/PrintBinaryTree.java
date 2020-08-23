// LEETCODE PROBLEM - 655
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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int cols = (1 << (height + 1)) - 1;
        
        List<List<String>> ans = new ArrayList<>();
        Queue<Pair> opQueue = new ArrayDeque<>();
        if(height < 0)
            return ans;
        
        int level = 0;
        opQueue.add(new Pair(root, cols / 2));
        while(opQueue.size() != 0) {
            String asf[] = new String[cols];
            Arrays.fill(asf, "");
            
            int gap = (cols >>> (level + 2)) + 1;
            int size = opQueue.size();
            for(int iter = 0 ; iter < size ; iter ++) {
                Pair ele = opQueue.remove();
                asf[ele.idx] = Integer.toString(ele.node.val);
                
                if(ele.node.left != null)
                    opQueue.add( new Pair(ele.node.left, ele.idx - gap));
                if(ele.node.right != null)
                    opQueue.add( new Pair(ele.node.right, ele.idx + gap));
            }
            level += 1;
            ans.add(Arrays.asList(asf));
        }
        
        return ans;
    }
    
    private class Pair {
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    
    private int getHeight(TreeNode node) {
        if(node == null)
            return -1;
        
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}