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
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> wraplist = new ArrayList<List<Integer>>();
//         Queue<TreeNode> queue = new LinkedList<>();
//         if(root == null) return wraplist;

//         queue.offer(root);
//         while(!queue.isEmpty()){
//             int level = queue.size();
//             List<Integer> sublist = new ArrayList<>();
//             for(int i = 0; i < level ; i++){
//                 if(queue.peek().left != null) queue.offer(queue.peek().left);
//                 if(queue.peek().right != null) queue.offer(queue.peek().right);
//                 sublist.add(queue.poll().val);
//             }
//             wraplist.add(sublist);
//         }
//         return wraplist;
//     }


//DFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int h = height(root);
        for(int i = 1 ; i <= h ; i++){
            List<Integer> level = new ArrayList<>();
            PrintNode(root , i , level);
            res.add(level);
        }
        return res;    
    }

    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left) , height(root.right));
    }

    void PrintNode(TreeNode root , int lvl , List<Integer>list){
        if(root == null) return ;
        if(lvl == 1){
            list.add(root.val);
        }else{
            PrintNode(root.left , lvl-1 , list);
            PrintNode(root.right , lvl-1 , list);
        }
    }
    
}