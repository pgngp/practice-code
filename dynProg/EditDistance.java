/**
 * Edit distance (70):
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * http://www.programcreek.com/2013/12/edit-distance-in-java/ 
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null || (word1.length() == 0 && word2.length() == 0)) {
            return 0;
        }

        int wl1 = word1.length();
        int wl2 = word2.length();
        int[] m = new int[wl1 + 1];
        for (int col = 0; col <= wl1; ++col) {
            m[col] = col;
        }

        char[] c1Arr = word1.toCharArray();
        char[] c2Arr = word2.toCharArray();
        for (int row = 1; row <= wl2; ++row) {
            int left = row;
            int curr = row;
            char c2 = c2Arr[row - 1];
            for (int col = 1; col <= wl1; ++col) {
                curr = (c1Arr[col - 1] == c2) ? curr = m[col - 1] : Math.min(left, Math.min(m[col - 1], m[col])) + 1;
                m[col - 1] = left;
                left = curr;
            }
            m[wl1] = curr;
        }

        return m[wl1];
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java <prog> <word1> <word2>");
            System.exit(1);
        }

        EditDistance ed = new EditDistance();
        int dist = ed.minDistance(args[0], args[1]);
        System.out.println("min dist: " + dist);   
    }
}

