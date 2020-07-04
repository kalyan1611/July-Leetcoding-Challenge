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

    public List <List<Integer>> levelOrderBottom(TreeNode root) {
        
        if (root == null) {
            return new LinkedList<>();
        }
            
        Queue <TreeNode> q = new LinkedList<>();
        List <List<Integer>> output = new LinkedList<>();
        List <Intege> current_level = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.remove();
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
                current_level.add(current.val);
            }
            output.add(current_level);
            current_level = new LinkedList<>();
        }
        Collections.reverse(output);
        return output;
    }
}
