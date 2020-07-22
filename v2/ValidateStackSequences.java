/* https://leetcode.com/problems/validate-stack-sequences/ */
class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length == 0 || popped.length == 0) {
            return true;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        int i = 0, j = 0;
        while (i < n) {
            stack.offerFirst(pushed[i]);
            while (!stack.isEmpty() && j < n && stack.peekFirst() == popped[j]) {
                stack.pollFirst();
                j++;
            }
            i++;
        }
        
        while (!stack.isEmpty()) {
            if (stack.pollFirst() != popped[j]) {
                return false;
            }
            j++;
        }
        
        if (j != n || !stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
