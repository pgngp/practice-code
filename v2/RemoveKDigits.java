class Solution {
    public String removeKdigits(String num, int k) {
        // add to stack; if top of stack is greater than current digit, pop the stack
        Deque<Character> stack = new ArrayDeque<>();
        stack.offerFirst(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peekFirst() > num.charAt(i)) {
                stack.pollFirst();
                k--;
            }
            stack.offerFirst(num.charAt(i));
        }
        
        // if k > 0, keep popping the stack
        while (k > 0) {
            stack.pollFirst();
            k--;
        }
        
        // transfer digits from stack to array
        char[] arr = new char[stack.size()];
        int idx = arr.length - 1;
        while (!stack.isEmpty()) {
            arr[idx] = stack.pollFirst();
            idx--;
        }
        
        // return empty string if arr is empty
        if (arr.length == 0) {
            return "0";
        }
        
        // create result string, ignoring the leading 0's
        idx = 0;
        while (idx < arr.length && arr[idx] == '0') {
            idx++;
        }
        String result = idx < arr.length ? new String(arr, idx, arr.length - idx) : "0";
        
        return result;
    }
}
