/* https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/ */
class MinRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.offerFirst(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pollFirst();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            set.add(stack.pollFirst());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
