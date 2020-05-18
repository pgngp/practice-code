/* https://leetcode.com/problems/permutation-in-string/ */

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        // check for edge cases
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        
        // keep count of each char in s1
        int[] s1Arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }
        
        // parse s2
        int[] s2Arr = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            s2Arr[s2.charAt(i) - 'a']++;
            
            if (i >= s1.length()) {
                s2Arr[s2.charAt(i - s1.length()) - 'a']--;
            }
            
            if (Arrays.equals(s1Arr, s2Arr)) {
                return true;
            }
        }
        
        return false;
    }
}
