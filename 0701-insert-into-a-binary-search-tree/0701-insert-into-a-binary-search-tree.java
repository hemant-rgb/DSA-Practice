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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode ptr = root;
        while(ptr!=null){
            if(ptr.val>val){
                if(ptr.left==null){
                    ptr.left = new TreeNode(val);
                    break;
                }
                ptr = ptr.left;


            }else{
                if(ptr.right==null){
                    ptr.right = new TreeNode(val);
                    break;
                }
                ptr = ptr.right;
            }

        }

        return root;

        
    }
}