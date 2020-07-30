/* https://leetcode.com/problems/minimum-window-subsequence/ */
class MinWindowSubseq {
    public String minWindow(String S, String T) {
        int i = 0, j = 0, n = S.length(), m = T.length(), end = 0, min = S.length() + 1;
        String minWindow = "";
        while (i < n && j < m) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
                if (j >= T.length()) {
                    end = i + 1;
                    j--;
                    while (j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) {
                            j--;
                        }
                        i--;
                    }
                    i++;
                    if (min > end - i) {
                        min = end - i;
                        minWindow = S.substring(i, end);
                    }
                    // i = end - 1;
                    j = 0;
                }
            }
            i++;
        }
        
        return minWindow;
    }
}
