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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res  = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < level ; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right!= null) q.offer(q.peek().right);
                list.add(q.poll().val);
            }
            res.add(list);
        }      
        return res;
    }
//DFS
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         int h = height(root);
//         for(int i = 1 ; i <= h ; i++){
//             List<Integer> level = new ArrayList<>();
//             PrintNode(root , i , level);
//             res.add(level);
//         }
//         return res;    
//     }

//     int height(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         return 1 + Math.max(height(root.left) , height(root.right));
//     }

//     void PrintNode(TreeNode root , int lvl , List<Integer>list){
//         if(root == null) return ;
//         if(lvl == 1){
//             list.add(root.val);
//         }else{
//             PrintNode(root.left , lvl-1 , list);
//             PrintNode(root.right , lvl-1 , list);
//         }
//     }
    
}