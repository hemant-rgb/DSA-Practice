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
    HashMap<Integer, TreeNode> roots = new HashMap<>();
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(TreeNode t : trees){
            roots.put(t.val,t);

            freq.put(t.val , freq.getOrDefault(t.val,0)+1);

            if(t.left!=null){
                freq.put(t.left.val , freq.getOrDefault(t.left.val,0)+1);
            }
            if(t.right!=null){
                freq.put(t.right.val,freq.getOrDefault(t.right.val,0)+1);
            }
        }

        TreeNode root = null;

        for(TreeNode t : trees){
            if(freq.get(t.val)==1){
                root = t;
                break;
            }
        }

        if(root == null){
            return null;
        }

        roots.remove(root.val);

        if(!dfs(root, Long.MIN_VALUE , Long.MAX_VALUE)){
            return null;
        }

        if(!roots.isEmpty()){
            return null;
        }
        return root;
        
    }

    private boolean dfs(TreeNode node , long low , long high){
        if(node == null){
            return true;
        }

        if(node.val <= low || node.val >= high){
            return false;
        }

        if(node.left == null && node.right == null && roots.containsKey(node.val)){
            TreeNode merge = roots.get(node.val);

            roots.remove(node.val);

            if(merge!=node){
                node.left = merge.left;
                node.right = merge.right;

            }
            
        }

        return dfs(node.left,low,node.val) && dfs(node.right , node.val , high);
    }
}