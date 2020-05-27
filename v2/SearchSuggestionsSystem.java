/* https://leetcode.com/problems/search-suggestions-system/ */
class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // construct trie
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode node = root;
            for (int i = 0; i < product.length(); i++) {
                char c = product.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();   
                }
                node = node.children[c - 'a'];
            }
            node.word = product;
        }
        
        // parse each letter of searchWord
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            char c = searchWord.charAt(i);
            if (root == null || root.children[c - 'a'] == null) {
                result.add(list);
                root = null;
            } else {
                root = root.children[c - 'a'];
                helper(root, list);
                result.add(list);
            }
        }
        
        return result;
    }
    
    private void helper(TrieNode root, List<String> list) {
        if (list.size() == 3) {
            return;
        } else if (root.word != null) {
            list.add(root.word);
        }
        
        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null) {
                continue;
            }
            helper(root.children[i], list);
        }
    }
    
    public class TrieNode {
        private TrieNode[] children;
        private String word;
        
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
}
