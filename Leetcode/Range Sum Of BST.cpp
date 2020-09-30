/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int dfs(TreeNode* node, int l, int r) {
       if(node == NULL)
            return 0;
        
        int asf = 0;
        if(node->val >= l && node-> val <= r)
            asf += node->val;
        
        asf += dfs(node->left, l, r);
        asf += dfs(node->right, l, r);
        return asf;
    }
    
    int rangeSumBST(TreeNode* root, int L, int R) {
        
        // SPEEDING UP THE PROCESS
        std::ios_base::sync_with_stdio(false);
        std::cin.tie(NULL);
        std::cout.tie(NULL);
        
        return dfs(root, L, R);
    }
};