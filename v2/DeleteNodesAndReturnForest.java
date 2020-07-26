/* https://leetcode.com/problems/delete-nodes-and-return-forest/ */
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
class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<Integer>();
        for (int num : to_delete) {
            toDelete.add(num);
        }
        
        List<TreeNode> result = new ArrayList<>();
        helper(root, result, toDelete);
        if (!toDelete.contains(root.val)) {
            result.add(root);   
        }
        
        return result;
    }
    
    private void helper(TreeNode node, List<TreeNode> result, Set<Integer> toDelete) {        
        if (node.left != null) {
            helper(node.left, result, toDelete);
            if (toDelete.contains(node.left.val)) {
                node.left = null;
            }
        }
        
        if (node.right != null) {
            helper(node.right, result, toDelete);
            if (toDelete.contains(node.right.val)) {
                node.right = null;
            }
        }
        
        if (toDelete.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            
            if (node.right != null) {
                result.add(node.right);
            }
        }
    }
}
