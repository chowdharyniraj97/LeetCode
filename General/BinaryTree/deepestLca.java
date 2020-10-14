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
    HashMap<Integer,List<TreeNode>> map;
    HashMap<TreeNode,TreeNode> parent;
    int max =0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null)
            return null;
        map = new HashMap<>();
        parent = new HashMap<>();
        
        
        inorder(root,null,0);
        
        List<TreeNode> list = map.get(max);
        HashSet<TreeNode> set = new HashSet<>();
        
        Queue<TreeNode> q = new LinkedList<>(list);
        
        while(q.size() > 1) {
            TreeNode x = q.poll();
            TreeNode p = parent.get(x);
            if(!set.contains(p)) {
                set.add(p);
                q.add(p);
            }
        }
        
        return q.poll();
        
       
        
        
    }
    
    void inorder(TreeNode root,TreeNode p,int level) {
        if(root == null) {
            return;
        }
        
        parent.put(root,p);
        if(map.containsKey(level) ) {
            map.get(level).add(root);
        }
        
        else{
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            map.put(level,list);
            max = Math.max(level,max);
        }
        
        inorder(root.left,root,level+1);
        inorder(root.right,root,level+1);
        
    }
}


/*

level and list
node and parent



*/
