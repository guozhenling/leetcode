package com.gzl.tesla;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
       return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
