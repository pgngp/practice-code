/* https://leetcode.com/problems/find-all-anagrams-in-a-string/ */
class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }
        
        // build reference
        int sLen = s.length(), pLen = p.length();
        int[] pArr = new int[26];
        for (int i = 0; i < pLen; i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        
        // parse first pLen number of chars in string s
        List<Integer> result = new ArrayList<>();
        int[] sArr = new int[26];
        for (int i = 0; i < pLen; i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArr, pArr)) {
            result.add(0);
        }
        
        // parse remaining chars in string s
        int start = 0;
        for (int i = pLen; i < sLen; i++) {
            sArr[s.charAt(i) - 'a']++;
            sArr[s.charAt(start) - 'a']--;
            start++;
            
            if (Arrays.equals(sArr, pArr)) {
                result.add(start);
            }
        }
        
        return result;
    }
}
