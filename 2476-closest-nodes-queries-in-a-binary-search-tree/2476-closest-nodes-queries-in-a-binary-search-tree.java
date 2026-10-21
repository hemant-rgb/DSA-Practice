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

    // seperate functions
    // private int ceil(TreeNode root , int key){
    //     int ceil=-1;
    //     while(root!=null){
    //         if(root.val == key){
    //             ceil =root.val;
    //             return ceil;
    //         }
    //         else if(root.val<key){
    //             root = root.right;

    //         }else{
    //             ceil = root.val;
    //             root = root.left;
    //         }
    //     }

    //     return ceil;
    // }

    // private int floor(TreeNode root , int key){
    //     int floor=-1;
    //     while(root!=null){
    //         if(root.val==key){
    //             floor=root.val;
    //             return floor;
    //         }
    //         else if (root.val>key){
    //             root=root.left;
    //         }else{
    //             floor = root.val;
    //             root = root.right;
    //         }
    //     }

    //     return floor;
    // }


    // merged them 
    // private List<Integer> solve(TreeNode root, int key){
    //     List<Integer> keyAns = new ArrayList<>();
    //     int floor=-1;
    //     int ceil=-1;
    //     while(root!=null){
    //         if(root.val==key){
    //             floor=root.val;
    //             ceil=root.val;
    //             break;
    //         }
    //         else if(root.val>key){
    //             ceil = root.val;
    //             root = root.left;
    //         }else{
    //             floor = root.val;
    //             root = root.right;
    //         }
    //     }

    //     keyAns.add(floor);
    //     keyAns.add(ceil);
    //     return keyAns;
    // }
    // public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int key : queries){
           
            
    //         ans.add(solve(root,key));
    //     }

    //     return ans;
        
    // }



    // above solution gives tle but passed 34/35 cases , it gives tle because of N * Q = 10^5 * 10^5 = 10^10
    // inorder + binarySearch

    private void inorder(TreeNode root , List<Integer>sortedValues){
        if(root==null){
            return;
        }

        inorder(root.left,sortedValues);
        sortedValues.add(root.val);
        inorder(root.right,sortedValues);

    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries){
        List<Integer> sortedValues = new ArrayList<>();
        inorder(root,sortedValues);

        List<List<Integer>> ans = new ArrayList<>();

        for(int key : queries){
            int floor =-1;
            int ceil=-1;
            int low=0;
            int high=sortedValues.size()-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                int val = sortedValues.get(mid);
                if(val == key){
                    floor =ceil = val;
                    break;
                }else if(val>key){
                    ceil = val;
                    high = mid-1;
                }else{
                    floor=val;
                    low = mid+1;
                }
            }

            ans.add(Arrays.asList(floor,ceil));



        }

        return ans;

    }


}