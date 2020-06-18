/* https://leetcode.com/problems/minimum-window-substring/ */
class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        
        // create reference map
        Map<Character, Integer> refMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            refMap.put(t.charAt(i), refMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        // create map to store the count of chars in t
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countMap.put(t.charAt(i), 0);
        }
        
        // use sliding window approach to find the min window
        int i = 0, j = 0, count = 0, resultI = -1, resultJ = resultI, minLen = Integer.MAX_VALUE;
        while (j < s.length()) {
            if (count == t.length()) {
                int len = j - i;
                if (minLen > len) {
                    minLen = len;
                    resultI = i;
                    resultJ = j - 1;
                }
                
                char c = s.charAt(i);
                if (countMap.containsKey(c)) {
                    int curr = countMap.get(c);
                    if (curr <= refMap.get(c)) {
                        count--;
                    }
                    countMap.put(c, curr - 1);   
                }
                i++;
            } else {
                char c = s.charAt(j);
                if (countMap.containsKey(c)) {
                    int curr = countMap.get(c);
                    if (curr < refMap.get(c)) {
                        count++;
                    }
                    countMap.put(c, curr + 1);
                }
                j++;   
            }
        }
        
        while (i < s.length() && count == t.length()) {
            int len = j - i;
            if (minLen > len) {
                minLen = len;
                resultI = i;
                resultJ = j - 1;
            }
            
            char c = s.charAt(i);
            if (countMap.containsKey(c)) {
                int curr = countMap.get(c);
                if (curr <= refMap.get(c)) {
                    count--;
                }
                countMap.put(c, curr - 1);   
            }
            i++;
        }
        
        return resultI == -1 ? "" : s.substring(resultI, resultJ + 1);
    }
}
