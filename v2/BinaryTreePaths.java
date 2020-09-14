/* https://leetcode.com/problems/binary-tree-paths/ */
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
class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left.size() == 0 && right.size() == 0) {
            list.add(root.val + "");
        } else if (left.size() == 0) {
            for (int i = 0; i < right.size(); i++) {
                list.add(root.val + "->" + right.get(i));
            }
        } else if (right.size() == 0) {
            for (int i = 0; i < left.size(); i++) {
                list.add(root.val + "->" + left.get(i));
            }
        } else {
            for (int i = 0; i < left.size(); i++) {
                list.add(root.val + "->" + left.get(i));
            }
            for (int i = 0; i < right.size(); i++) {
                list.add(root.val + "->" + right.get(i));
            }
        }
        
        return list;
    }
}
