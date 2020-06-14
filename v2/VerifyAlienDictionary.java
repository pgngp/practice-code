/* https://leetcode.com/problems/verifying-an-alien-dictionary/ */
class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] seq = new int[26];
        for (int i = 0; i < order.length(); i++) {
            seq[order.charAt(i) - 'a'] = i;
        }
        
        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            boolean equalSoFar = true;
            int len = prev.length() < curr.length() ? prev.length() : curr.length();
            for (int j = 0; j < len; j++) {
                int prevPos = seq[prev.charAt(j) - 'a'];
                int currPos = seq[curr.charAt(j) - 'a'];
                if (prevPos > currPos) {
                    return false;
                } else if (prevPos < currPos) {
                    equalSoFar = false;
                    break;
                }
            }
            
            if (equalSoFar && prev.length() > curr.length()) {
                return false;
            }
            
            prev = curr;
        }
        
        return true;
    }
}
