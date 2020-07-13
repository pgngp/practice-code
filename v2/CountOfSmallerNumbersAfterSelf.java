/* https://leetcode.com/problems/count-of-smaller-numbers-after-self/ */
class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        // check edge cases
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // find smaller-number count using BST
        int n = nums.length;
        Node root = new Node(nums[n - 1]);
        result.add(0);
        for (int i = n - 2; i >= 0; i--) {
            result.add(insertNode(root, new Node(nums[i])));
        }
        
        // reverse the list
        Collections.reverse(result);
        
        return result;
    }
    
    private int insertNode(Node root, Node node) {
        int count = 0;
        while (root != null) {
            if (root.val < node.val) {
                count += root.count;
                if (root.right == null) {
                    root.right = node;
                    break;
                }
                root = root.right;
            } else {  // root >= node
                root.count++;
                if (root.left == null) {
                    root.left = node;
                    break;
                }
                root = root.left;
            }
        }
        
        return count;
    }
    
    class Node {
        private int val;
        private int count;
        private Node left;
        private Node right;
        
        public Node(int val) {
            this.val = val;
            this.count = 1;
            this.left = null;
            this.right = null;
        }
    }
}
