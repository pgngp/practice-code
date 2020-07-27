/* https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ */
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
class ConstructBinaryTreeFromInOrderAndPostOrderTraversal {
    private int postorderIdx;
    private int[] inorder;
    private int[] postorder;
    private Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // check for valid input
        if (inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }   
        
        // initialize member variables
        this.postorderIdx = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            this.map.put(inorder[i], i);
        }
        
        // create tree
        int rootVal = postorder[postorderIdx];
        TreeNode root = new TreeNode(rootVal);
        int inorderPos = map.get(rootVal);
        root.right = helper(inorderPos + 1, inorder.length - 1);
        root.left = helper(0, inorderPos - 1);
        
        return root;
    }
    
    private TreeNode helper(int inorderBegin, int inorderEnd) {
        if (inorderBegin > inorderEnd) {
            return null;
        }
        
        // create subtree
        postorderIdx--;
        int rootVal = postorder[postorderIdx];
        TreeNode root = new TreeNode(rootVal);
        int inorderPos = map.get(rootVal);
        root.right = helper(inorderPos + 1, inorderEnd);
        root.left = helper(inorderBegin, inorderPos - 1);
        
        return root;
    }
}

