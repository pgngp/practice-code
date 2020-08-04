/* https://leetcode.com/problems/expressive-words/ */
class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        // create map for S (time: O(S); space: O(S))
        Map<Character, Map<Integer, Integer>> mapS = createMap(S);
        
        // create map for each word and compare the maps (time: O(N * W); space: O(W))
        int count = 0;
        for (String word : words) {
            Map<Character, Map<Integer, Integer>> mapW = createMap(word);
            if (isStretchy(mapS, mapW, word)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isStretchy(
        Map<Character, Map<Integer, Integer>> mapS, 
        Map<Character, Map<Integer, Integer>> mapW, 
        String word
    ) {
        if (mapS.keySet().size() != mapW.keySet().size()) {
            return false;
        }
        
        int i = 0, j = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (!mapS.containsKey(c)) {
                return false;
            }
            Map<Integer, Integer> tmpMapS = mapS.get(c);
            Map<Integer, Integer> tmpMapW = mapW.get(c);
            
            if (tmpMapS.keySet().size() != tmpMapW.keySet().size()) {
                return false;
            } else if (tmpMapS.getOrDefault(j, 0) < 3) {
                if (tmpMapS.getOrDefault(j, 0) != tmpMapW.get(i)) {
                    return false;
                }
            } else if (tmpMapS.getOrDefault(j, 0) < tmpMapW.get(i)) {
                return false;
            }
            
            j += tmpMapS.get(j);
            i += tmpMapW.get(i);
        }
        
        return true;
    }
    
    private Map<Character, Map<Integer, Integer>> createMap(String s) {
        Map<Character, Map<Integer, Integer>> map = new HashMap<>();
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new HashMap<>());
            }
            Map<Integer, Integer> tmpMap = map.get(c);
            tmpMap.put(i, 1);
            
            int j = i + 1;
            if (j < n && s.charAt(j) == c) {
                while (j < n && s.charAt(j) == c) {
                    tmpMap.put(i, tmpMap.get(i) + 1);
                    j++;
                }
                i = j - 1;
            }
            i++;
        }
        
        return map;
    }
}
