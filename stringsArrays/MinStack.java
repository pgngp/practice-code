/**
 * Min stack (217):
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * http://www.programcreek.com/2014/02/leetcode-min-stack-java/
 */

import java.util.*;

public class MinStack {
    private Deque<Integer> q;
    private TreeMap<Integer, Integer> map;
    private int min;

    public MinStack() {
        q = new ArrayDeque<>();
        map = new TreeMap<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        q.addFirst(x);
        map.put(x, map.getOrDefault(x, 0) + 1);
        min = Math.min(min, x);
    }
    
    public void pop() {
        int x = top();
        q.removeFirst();
        if (map.get(x) > 1) {
            map.put(x, map.get(x) - 1);
        } else {
            map.remove(x);
            min = map.size() == 0 ? Integer.MAX_VALUE : map.firstKey();
        }
    }
    
    public int top() {
        return q.getFirst();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getmin: " + minStack.getMin());
        minStack.pop();
        System.out.println("top: " + minStack.top());
        System.out.println("getmin: " + minStack.getMin());
    }
}
