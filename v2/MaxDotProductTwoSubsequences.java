/* https://leetcode.com/problems/max-dot-product-of-two-subsequences/ */

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] m = new int[nums1.length][nums2.length];
        m[0][0] = nums1[0] * nums2[0];
        
        // top row
        for (int c = 1; c < m[0].length; c++) {
            int prod = nums1[0] * nums2[c];
            m[0][c] = Math.max(prod, m[0][c - 1]);
        }
        
        // left-most col
        for (int r = 1; r < m.length; r++) {
            int prod = nums1[r] * nums2[0];
            m[r][0] = Math.max(prod, m[r - 1][0]);
        }
        
        // remaining
        for (int r = 1; r < m.length; r++) {
            for (int c = 1; c < m[0].length; c++) {
                int prod = nums1[r] * nums2[c];
                m[r][c] = Math.max(prod + Math.max(m[r - 1][c - 1], 0), Math.max(m[r][c - 1], m[r - 1][c]));
            }
        }
        // print(m);
        
        return m[m.length - 1][m[0].length - 1];
    }
    
    private void print(int[][] m) {
        System.out.println("Matrix:");
        System.out.println("[");
        for (int r = 0; r < m.length; r++) {
            System.out.print("[ ");
            for (int c = 0; c < m[0].length; c++) {
                System.out.print(m[r][c] + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
