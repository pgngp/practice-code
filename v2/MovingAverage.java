/* https://leetcode.com/problems/moving-average-from-data-stream/ */
class MovingAverage {
    private Deque<Integer> deq;
    private int sum;
    private int maxSize;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        deq = new ArrayDeque<>();
        sum = 0;
        maxSize = size;
    }
    
    public double next(int val) {
        sum += val;
        deq.offerLast(val);
        if (deq.size() > maxSize) {
            sum -= deq.pollFirst();
        }
        
        return (double) sum / deq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
