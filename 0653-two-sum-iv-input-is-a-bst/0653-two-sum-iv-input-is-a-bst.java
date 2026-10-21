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
public class BSTIterator{
    private Stack<TreeNode> st =new Stack<>();
    boolean reverse = false;
    BSTIterator(TreeNode root , boolean isReversed){
        reverse = isReversed;
        pushAll(root);
    }
    public int next(){
        TreeNode node = st.pop();
        if(reverse == false && node.right!=null){
            pushAll(node.right);
        }

        if(reverse == true && node.left!=null){
            pushAll(node.left);
        }

        return node.val;
    }



    public boolean hasNext(){
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse == false){
                 node = node.left;
            }
            else{
                node = node.right;
            }
        }

    }
}
class Solution {

    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);

        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k) return true;
            else if (i+j>k){
                if(!r.hasNext())return false;
                j = r.next();
            }else{
                if(!l.hasNext())return false;
                i = l.next();
            }
        }

        return false;


        
    }
}