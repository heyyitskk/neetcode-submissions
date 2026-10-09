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
    private int helper(TreeNode n, int max){
        if(n == null) return 0;
        int ans = (n.val >= max) ? 1 : 0;
        max = Math.max(n.val, max);    
        ans += helper(n.left, max);
        ans += helper(n.right, max);
        return ans;
    }
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }
}
