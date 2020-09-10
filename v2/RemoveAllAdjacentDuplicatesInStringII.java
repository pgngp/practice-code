/* https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/ */
class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> deq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (deq.isEmpty() || deq.peekFirst().ch != s.charAt(i)) {
                deq.offerFirst(new Pair(s.charAt(i), 1));
            } else {
                Pair pair = deq.peekFirst();
                pair.count++;
                if (pair.count == k) {
                    deq.pollFirst();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            Pair p = deq.pollLast();
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);   
            }
        }
        
        return sb.toString();
    }
    
    class Pair {
        private char ch;
        private int count;
        
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
