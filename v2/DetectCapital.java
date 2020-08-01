/* https://leetcode.com/problems/detect-capital/ */
class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int n = word.length(), numLower = 0, numUpper = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                numUpper++;
            } else {
                numLower++;
            }
        }
        
        if (numUpper == n || numLower == n || (numUpper == 1 && Character.isUpperCase(word.charAt(0)))) {
            return true;
        }
        
        return false;
    }
}
