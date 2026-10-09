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
    int ans = 0;
    // int max = Integer.MIN_VALUE;
    private void helper(TreeNode n, int max){
        if(n == null) return;
        if(n.val >= max) ans++;
        max = Math.max(n.val, max);    
        helper(n.left, max);
        helper(n.right, max);
    }
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return ans;
    }
}
