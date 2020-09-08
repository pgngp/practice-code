/* https://leetcode.com/problems/word-pattern/ */
class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!charToWordMap.containsKey(pattern.charAt(i)) && wordToCharMap.containsKey(words[i])) {
                return false;
            } else if (charToWordMap.containsKey(pattern.charAt(i)) && !wordToCharMap.containsKey(words[i])) {
                return false;
            } else if ((charToWordMap.containsKey(pattern.charAt(i)) && !charToWordMap.get(pattern.charAt(i)).equals(words[i])) || 
                       (wordToCharMap.containsKey(pattern.charAt(i)) && !wordToCharMap.get(words[i]).equals(pattern.charAt(i)))) {
                return false;
            } else {
                charToWordMap.put(pattern.charAt(i), words[i]);
                wordToCharMap.put(words[i], pattern.charAt(i));
            }
        }
        
        return true;
    }
}
