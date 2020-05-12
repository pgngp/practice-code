class AutocompleteSystem {
    private TrieNode root;
    private TrieNode currNode;
    private String currStr;
    private int limit = 3;

    // constructor
    public AutocompleteSystem(String[] sentences, int[] times) {
        // build trie
        root = new TrieNode();
        for (int i = 0; i < sentences.length; ++i) {
            String sentence = sentences[i];
            TrieNode node = root;
            for (int j = 0; j < sentence.length(); ++j) {
                char c = sentence.charAt(j);
                TrieNode tmp = node.children.getOrDefault(c, null);
                if (tmp == null) {
                    tmp = new TrieNode();
                    node.children.put(c, tmp);
                }
                node = tmp;
            }
            node.sentence = sentence;
            node.times = times[i];
        }
        // System.out.println("########");
        // root.print(root);
        // System.out.println("########");
        
        currStr = "";
        currNode = root;
    }
    
    // input char
    public List<String> input(char c) {
        if (c == '#') {
            currNode = root;
            addCurrentSentenceToTrie();
            currStr = "";
            return new ArrayList<>();
        }
        currStr += Character.toString(c);
        
        return getRankedSuggestions(c);
    }
    
    // get top ranked suggestions
    private List<String> getRankedSuggestions(char c) {
        if (currNode == null) {
            return new ArrayList<>();
        }
        
        // go to lowest parent of associated suggestions
        currNode = currNode.children.getOrDefault(c, null);
        if (currNode == null) {
            return new ArrayList<>();
        }
        
        // get suggestions
        List<Suggestion> suggestions = new ArrayList<>();
        getSentences(currNode, suggestions);
        Collections.sort(suggestions, (a, b) -> {
            if (a.times != b.times) {
                return b.times - a.times;
            }
            return a.sentence.compareTo(b.sentence);
        });
        
        // store top suggestions into list
        List<String> result = new ArrayList<>();
        for (int i = 0; i < limit && i < suggestions.size(); ++i) {
            result.add(suggestions.get(i).sentence);
        }
        
        return result;
    }
    
    // get sentences within the given node
    private void getSentences(TrieNode node, List<Suggestion> suggestions) {       
        // if end of sentence, add it to list
        if (node.sentence != null) {
            Suggestion s = new Suggestion(node.sentence, node.times);
            suggestions.add(s);
        }
        
        // parse children
        for (char c : node.children.keySet()) {
            getSentences(node.children.get(c), suggestions);
        }
    }
    
    // add current sentence to trie
    private void addCurrentSentenceToTrie() {       
        if (currStr.length() == 0) {
            return;
        }
        
        String sentence = currStr;
        TrieNode node = root;
        for (int i = 0; i < sentence.length(); ++i) {
            char c = sentence.charAt(i);
            TrieNode tmp = node.children.getOrDefault(c, null);
            if (tmp == null) {
                tmp = new TrieNode();
                node.children.put(c, tmp);
            }
            node = tmp;
        }
        node.sentence = sentence;
        node.times++;   
    }
    
    // trienode class
    public class TrieNode {
        private Map<Character, TrieNode> children;
        private String sentence;
        private int times;
        
        public TrieNode() {
            children = new HashMap<>();
            sentence = null;
            times = 0;
        }
        
        public void print(TrieNode node) {
            if (node == null) {
                return;
            }
            
            if (node.sentence != null) {
                System.out.println(node.sentence + " " + node.times);
            }
            
            for (char c : node.children.keySet()) {
                print(node.children.get(c));
            }
        }
    }
    
    // suggestion class
    public class Suggestion {
        private String sentence;
        private int times;
        
        public Suggestion(String sentence, int times) {
            this.sentence = sentence;
            this.times = times;
        }
        
        @Override
        public String toString() {
            return sentence + " " + Integer.toString(times);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
