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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        TreeMap<Integer,List<Integer>> map =new TreeMap<>(Collections.reverseOrder());
        
        addNodes(root,map,0);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        for(Integer lvl : map.keySet()){
            ArrayList<Integer> lst=new ArrayList<>();
            for(int node : map.get(lvl))
                lst.add(node);
            
            ans.add(lst);
            
        }
        return ans;
    }
    
    void addNodes(TreeNode root,TreeMap<Integer,List<Integer>> map,int lvl){
        if(root==null)
            return;
        
        if(map.containsKey(lvl)){
            List<Integer> l=map.get(lvl);
            l.add(root.val);
            map.put(lvl,l);
            
        
        }
        else{
            ArrayList<Integer> lst=new ArrayList<>();
            lst.add(root.val);
            map.put(lvl,lst);
        }
        
        addNodes(root.left,map,lvl+1);
        addNodes(root.right,map,lvl+1);
        
        
    }
}
