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
    int preIndex =0;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }

        return build(preorder,0,inorder.length-1);
        
    }

    private TreeNode build(int[]preorder , int inStart, int inEnd){
        if(inStart> inEnd){
            return null;
        }
        int val = preorder[preIndex++];
        int index = map.get(val);

        TreeNode root = new TreeNode(val);
        root.left = build(preorder,inStart,index-1);
        root.right = build(preorder,index+1,inEnd);

        return root;
    }
}