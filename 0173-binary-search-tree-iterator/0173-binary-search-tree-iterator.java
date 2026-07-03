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
class BSTIterator {
    private List<Integer> map;
    private int index;
    public BSTIterator(TreeNode root) {
        map = new ArrayList<>();
        index=0;
        inorder(root);
        
    }

    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        map.add(node.val);
        inorder(node.right);
    }
    
    public int next() {
        return map.get(index++);
        
    }
    
    public boolean hasNext() {
        return index<map.size();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */