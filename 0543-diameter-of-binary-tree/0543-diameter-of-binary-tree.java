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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        Height(root);
        return diameter;
        
    }

    private int Height(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = Height(node.left);
        int right = Height(node.right);
        diameter = Math.max(diameter, left+right);

        return 1 + Math.max(left,right);

    }
}