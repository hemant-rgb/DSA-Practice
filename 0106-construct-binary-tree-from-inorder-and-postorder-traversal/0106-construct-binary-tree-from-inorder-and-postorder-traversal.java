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
    HashMap<Integer,Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return build(postorder,0 , inorder.length-1);
    }

    private TreeNode build(int[]postorder,int inStart,int inEnd){
        if(inStart>inEnd){
            return null;

        }

        int val = postorder[postIndex--];
        int index = map.get(val);

        TreeNode node = new TreeNode(val);

        
        node.right = build(postorder,index+1,inEnd);
        node.left = build(postorder,inStart,index-1);
        

        return node;

    }
}