/* https://leetcode.com/problems/stream-of-characters/ */
class StreamChecker {
    TrieNode root;
    Deque<Character> deq;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        deq = new ArrayDeque<>();
        
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (node.arr[c - 'a'] == null) {
                    node.arr[c - 'a'] = new TrieNode();
                }
                node = node.arr[c - 'a'];
            }
            node.isEndOfWord = true;
        }
    }
    
    public boolean query(char letter) {
        deq.offerFirst(letter);
        
        TrieNode node = root;
        for (char c : deq) {
            if (node.arr[c - 'a'] == null) {
                return false;
            }
            node = node.arr[c - 'a'];
            if (node.isEndOfWord) {
                return true;
            }
        }
        
        return false;
    }
    
    class TrieNode {
        TrieNode[] arr;
        boolean isEndOfWord;
        
        TrieNode() {
            arr = new TrieNode[26];
            isEndOfWord = false;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
