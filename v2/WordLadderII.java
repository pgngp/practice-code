/* https://leetcode.com/problems/word-ladder-ii */
class WordLadderII {
    private List<List<String>> result;
    
    // main function
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        result = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return result;
        }
        
        // create notVisited set
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)) {
            return result;
        }
        notVisited.remove(beginWord);
        
        // get min level
        Map<String, List<String>> map = new HashMap<>();
        int min = bfs(beginWord, endWord, new HashSet<>(notVisited), map);
        
        // get transformations
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(beginWord, endWord, map, list, min);
        
        return result;
    }
    
    // get min level
    private int bfs(String beginWord, String endWord, Set<String> notVisited, Map<String, List<String>> map) {
        List<String> beginQ = new ArrayList<>();
        beginQ.add(beginWord);
        int level = 1;
        boolean reachedEnd = false;
        while (!beginQ.isEmpty()) {
            List<String> beginQNew = new ArrayList<>();
            for (int k = 0; k < beginQ.size(); k++) {
                String word = beginQ.get(k);
                map.put(word, new ArrayList<>());
                List<String> list = map.get(word);
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char orig = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = String.valueOf(arr);
                        if (!notVisited.contains(newWord)) {
                            continue;
                        }
                        if (newWord.equals(endWord)) {
                            reachedEnd = true;
                        }
                        beginQNew.add(newWord);
                        list.add(newWord);
                    }
                    arr[i] = orig;
                }
            }
            
            if (reachedEnd) {
                break;
            }
            
            for (String word : beginQNew) {
                notVisited.remove(word);
            }
            
            beginQ = beginQNew;
            level++;
        }

        return level + 1;
    }
    
    // get transformations
    private void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<String> transformations, int levels) {
        if (levels < 1) {
            return;
        } else if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(transformations));
            return;
        }
        
        if (!map.containsKey(beginWord) || map.get(beginWord).isEmpty()) {
            return;
        }
        
        List<String> list = map.get(beginWord);
        for (String word : list) {
            transformations.add(word);
            dfs(word, endWord, map, transformations, levels - 1);
            transformations.remove(transformations.size() - 1);
        }
    }
}
