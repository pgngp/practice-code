/* https://leetcode.com/problems/concatenated-words/ */
class ConcatenatedWords {
    // main function
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        
        // contruct trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.arr[c - 'a'] == null) {
                    node.arr[c - 'a'] = new TrieNode();
                }
                node = node.arr[c - 'a'];
            }
            node.word = word;
        }
        
        // go through trie to find concatenated words
        for (String word: words) {
            // System.out.println("word: " + word);
            int count = numConcatenated(word, root);
            // System.out.println("count: " + count);
            // System.out.println("######################");
            if (count > 1) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    // get number of concatenations
    private int numConcatenated(String word, TrieNode root) {
        TrieNode node = root;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            node = node.arr[word.charAt(i) - 'a'];
            if (node == null) {
                return 0;
            }
            
            if (node.word != null) {
                if (i == word.length() - 1) {
                    count = 1;
                    break;
                }
                count = 1 + numConcatenated(word.substring(i + 1), root);
                // System.out.println("  word: " + word.substring(i + 1) + ", count: " + count);
                if (count > 1) {
                    break;
                }
            }
        }
        
        return node.word == null ? 0 : count;
    }
    
    
    // TrieNode
    public class TrieNode {
        private TrieNode[] arr;
        private String word;
        
        public TrieNode() {
            arr = new TrieNode[26];
            word = null;
        }
    }
}
