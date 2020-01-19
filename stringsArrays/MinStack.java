/**
 * Min stack (217):
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * http://www.programcreek.com/2014/02/leetcode-min-stack-java/
 */

/*
 * time: O(1)
 * space: O(1)
 */

import java.util.*;
import javafx.util.*;

public class MinStack {
    private Deque<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new ArrayDeque<>();      
    }
    
    public void push(int x) {
        int min = stack.size() > 0 ? Math.min(x, getMin()) : x;
        Pair<Integer, Integer> pair = new Pair<>(x, min);
        stack.offerLast(pair);
    }
    
    public void pop() {
        stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast().getKey();
    }
    
    public int getMin() {
        return stack.peekLast().getValue();
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
