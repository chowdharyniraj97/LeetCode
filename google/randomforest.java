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
    List<TreeNode> list;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        list = new ArrayList<>();
        Set<Integer> toBeDeletedNodes = new HashSet<>();
        for(int x : to_delete) {
            toBeDeletedNodes.add(x);
        }
        
        preOrderTraveral(root, toBeDeletedNodes,null);
        return list;
    }
    
    
    void preOrderTraveral(TreeNode root, Set<Integer> toBeDeletedNodes,TreeNode parent) {
        if(root == null) {
            return;
        }
        
        
        if(toBeDeletedNodes.contains(root.val)) {
            if(parent!=null) {
                if(parent.left!=null && parent.left == root ) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            preOrderTraveral(root.left,toBeDeletedNodes, null );
            preOrderTraveral(root.right,toBeDeletedNodes, null );
            
            
        }
        
        else{
             
            preOrderTraveral(root.left,toBeDeletedNodes, root );
            preOrderTraveral(root.right,toBeDeletedNodes, root );
            if(parent == null) {
                 list.add(root);
            }
        }
        
        
       
    }
}
