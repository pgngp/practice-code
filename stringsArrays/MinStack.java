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
    private Queue<Integer> heap;

    public MinStack() {
        this.q = new ArrayDeque<>();
        this.heap = new PriorityQueue<>();
    }
    
    public void push(int x) {
        this.q.addFirst(x);
        this.heap.offer(x);
    }
    
    public void pop() {
        this.heap.remove(top());
        this.q.removeFirst();
    }
    
    public int top() {
        return this.q.getFirst();
    }
    
    public int getMin() {
        return this.heap.peek();
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
