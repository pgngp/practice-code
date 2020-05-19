/* https://leetcode.com/problems/online-stock-span/ */
class StockSpanner {
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peekFirst()[0] <= price) {
            count += stack.pop()[1];
        }
        stack.offerFirst(new int[] {price, count});
        
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
 
