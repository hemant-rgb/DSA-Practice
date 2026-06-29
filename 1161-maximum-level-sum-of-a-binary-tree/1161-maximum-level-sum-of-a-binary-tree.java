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
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        int maximal = Integer.MIN_VALUE;

        int level =0;
        int maxLevel =1;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int currSum =0;
            level++;
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                currSum += node.val;

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }

            }
            if(currSum> maximal){
                maximal = currSum;
                maxLevel = level;
            }


           

        }


        return maxLevel;

        
    }
}