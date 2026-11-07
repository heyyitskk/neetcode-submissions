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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n == null){
                sb.append("N,");
            }
            else{
                sb.append(n.val).append(",");
                q.add(n.left);
                q.add(n.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String vals[] = data.split(",");
        if((vals[0]).equals("N")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        int i = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!vals[i].equals("N")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(node.left);
            }
            i++;
            if(!vals[i].equals("N")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}
