/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    private void preorder(TreeNode node , StringBuilder sb){
        if(node == null){
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        preorder(node.left,sb);
        preorder(node.right,sb);  
    }
    int index=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String [] arr = data.split(",");

        TreeNode root = build(arr);
        index=0;

        return root;
        
        
    }

    private TreeNode build(String[] arr){
        if(arr[index].equals("N")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));

        index++;
        node.left = build(arr);
        node.right = build(arr);

        return node;


    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));