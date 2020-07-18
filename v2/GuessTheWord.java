/* https://leetcode.com/problems/guess-the-word/ */
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class GuessTheWord {
    int totalCalls = 0;
    
    public void findSecretWord(String[] wordlist, Master master) {
        // corner cases
        if (wordlist == null || wordlist.length == 0) {
            return;
        }
        
        // find # 0-matches for each word
        int n = wordlist.length;
        int[] numZeroMatches = new int[n];
        Map<String, Map<String, Integer>> numMatchesMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String word1 = wordlist[i];
            for (int j = i + 1; j < n; j++) {
                String word2 = wordlist[j];               
                int count = getNumMatches(word1, word2);
                
                // update numZeroMatches array
                if (count == 0) {
                    numZeroMatches[i]++;
                    numZeroMatches[j]++;
                }
                
                // update numMatchesMap for word1
                if (!numMatchesMap.containsKey(word1)) {
                    numMatchesMap.put(word1, new HashMap<>());
                }
                numMatchesMap.get(word1).put(word2, count);
                
                // update numMatchesMap for word2
                if (!numMatchesMap.containsKey(word2)) {
                    numMatchesMap.put(word2, new HashMap<>());
                }
                numMatchesMap.get(word2).put(word1, count);
            }
        }
        
        // select word with lowest # 0-matches
        int minVal = Integer.MAX_VALUE, minIdx = -1;
        for (int i = 0; i < n; i++) {
            if (minVal > numZeroMatches[i]) {
                minVal = numZeroMatches[i];
                minIdx = i;
            }
        }
        
        // call master.guess() with the word ('candidateWord') with lowest # 0-matches
        String candidateWord = wordlist[minIdx];
        int numMatches = master.guess(candidateWord);
        if (numMatches == 6) {
            return;
        }
        
        // only keep words that have exactly 'numMatches' matches with candidateWord
        List<String> newWordList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != minIdx && numMatchesMap.get(candidateWord).get(wordlist[i]) == numMatches) {
                newWordList.add(wordlist[i]);
            }
        }
        
        // call function recursively with the smaller list of words
        totalCalls++;
        if (totalCalls < 10 && newWordList.size() > 0) {
            findSecretWord(newWordList.toArray(new String[0]), master);
        }
    }
    
    // returns # char matches between word1 and word2
    private int getNumMatches(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        
        return count;
    }
}
