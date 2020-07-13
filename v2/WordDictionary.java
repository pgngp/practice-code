class WordDictionary {
    private Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie node = root;
        for (int i = 0; i < word.length(); i++) {
            int codepoint = word.charAt(i) - 'a';
            if (node.children[codepoint] == null) {
                node.children[codepoint] = new Trie();
            }
            node = node.children[codepoint];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    char c2 = (char) ('a' + j);
                    if (i < word.length() - 1) {
                        if (search(word.substring(0, i) + c2 + word.substring(i + 1))) {
                            return true;
                        }
                    } else {
                        if (search(word.substring(0, i) + c2)) {
                            return true;
                        }   
                    }
                }
                
                return false;
            } else {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
        }
        
        return node.word == null ? false : true;
    }
    
    class Trie {
        private Trie[] children;
        private String word;
        
        public Trie() {
            children = new Trie[26];
            word = null;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
