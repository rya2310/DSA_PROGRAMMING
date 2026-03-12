/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans= null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fun(root,p,q);
        return ans;
    }

    public int fun(TreeNode root , TreeNode p , TreeNode q){
        if(root == null) return 0;

        int left = fun(root.left , p , q);
        int right = fun(root.right , p , q);

        int self = (root == p || root == q)? 1:0;
        int total = left + self + right;
        if(total >= 2 || ans == null){
            ans = root;
        }
        return total > 0 ? 1 : 0;
    }


}