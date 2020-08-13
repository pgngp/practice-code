/* https://leetcode.com/problems/iterator-for-combination/ */
class CombinationIterator {
    private String chars;
    private int k;
    private Deque<String> q;
    
    public CombinationIterator(String characters, int combinationLength) {
        chars = characters;
        k = combinationLength;
        
        // precompute
        q = new ArrayDeque<>();
        int n = chars.length();
        for (int bitmask = 0; bitmask < (1 << n); bitmask++) {
            if (Integer.bitCount(bitmask) != k) {
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((bitmask & (1 << n - i - 1)) != 0) {
                    sb.append(chars.charAt(i));
                }
            }
            q.offerFirst(sb.toString());
        }
    }
    
    public String next() {
        return q.pollFirst();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
