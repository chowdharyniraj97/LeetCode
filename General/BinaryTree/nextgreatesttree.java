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
    public TreeNode bstToGst(TreeNode root) {
        
        findSum( root,0);
        return root;
        
    }
    
    int findSum(TreeNode root,int prev) {
        if(root == null)
            return 0;
        
        int right = findSum(root.right,prev);
        int temp = root.val;
        root.val = right + root.val + prev;
        
        int left =findSum(root.left,root.val);
        
        return temp + right + left;
        
        
        
        
    }
}

/*

for every node
is parent + its right
parent added only is your are the elft of parent.

left needs parents rigjt so we will evaluate the right
we do post order
calculate left and right andto root add itslef +right but return right+left+itself
starter sum to eevry node when you go right give sum as 0
and in left give it right+itslef.

value = sum + right + itself.
sum =0 when we are at right
left return sum of all its node

*/
