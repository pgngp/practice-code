/* https://leetcode.com/problems/delete-node-in-a-bst/ */
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
class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        TreeNode node = root, parent = null;
        while (node != null && node.val != key) {
            parent = node;
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        
        if (node == null) {
            return root;
        }
        
        TreeNode succ = successor(node), pred = predecessor(node);
        if (succ != null) {
            int tmp = succ.val;
            deletePredOrSucc(node, succ);
            node.val = tmp;
        } else if (pred != null) {
            int tmp = pred.val;
            deletePredOrSucc(node, pred);
            node.val = tmp;
        } else if (parent != null) {
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else {
            return null;
        }
        
        return root;
    }
    
    private void deletePredOrSucc(TreeNode root, TreeNode node) {
        if (node.left != null || node.right != null) {
            deleteNode(node, node.val);    
            return;
        }
        
        TreeNode parent = null;
        while (root.val != node.val) {
            parent = root;
            if (root.val < node.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        
        if (parent.left == node) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }
    
    private TreeNode successor(TreeNode root) {
        if (root.right == null) {
            return null;
        }
        
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
    
    private TreeNode predecessor(TreeNode root) {
        if (root.left == null) {
            return null;
        }
        
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        
        return root;
    }
}
