/* https://leetcode.com/problems/longest-palindrome/ */
class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = 'z' - 'A' + 1;
        int[] cache = new int[len];
        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i) - 'A']++;
        }
        
        int evenCount = 0;
        boolean hasOdd = false;
        for (int i = 0; i < len; i++) {
            if ((cache[i] % 2) == 0) {
                evenCount += cache[i];
            } else {
                hasOdd = true;
                evenCount += cache[i] - 1;
            }
        }
        
        return evenCount + (hasOdd ? 1 : 0);
    }
}
