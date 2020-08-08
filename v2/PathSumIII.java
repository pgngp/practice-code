/* https://leetcode.com/problems/path-sum-iii/ */
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
class PathSumIII {    
    public int pathSum(TreeNode root, int sum) {
        return helper(root, sum, 0, new HashMap<>());
    }
    
    private int helper(TreeNode node, int target, int sum, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        
        int count = 0;
        sum += node.val;
        if (sum == target) {
            count++;
        }
        
        count += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += helper(node.left, target, sum, map) + helper(node.right, target, sum, map);
        map.put(sum, map.get(sum) - 1);
        
        return count;
    }
}
