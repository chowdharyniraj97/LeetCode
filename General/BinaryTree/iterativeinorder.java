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

/*
ans =[1,3]
stack = 2 
top =2





*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        HashSet<TreeNode> set = new HashSet<>();
        Stack<TreeNode> st = new Stack<>();
        List<Integer>ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode top = st.peek();
            if(!set.contains(top) && top.left!= null){
                set.add(top);
                st.push(top.left);
            }
            else
            {
                st.pop();
                ans.add(top.val);
                if(top.right!=null)
                    st.push(top.right);
            }
        }
        
        return ans;
        
    }
}

/*

we will have a stack
keep pushing until null
as we hit null we pop top print that and go to the right

*/
