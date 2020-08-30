import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack. 
 */

class MinStack {
    private Stack<Integer> mStack;
    private Stack<Integer> mMinStack;

    /** initialize your data structure here. */
    public MinStack() {
        mStack = new Stack<Integer>();
        mMinStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        mStack.push(x);
        if (!mMinStack.isEmpty()) {
            int min = mMinStack.peek();
            if (x <= min) {
                mMinStack.push(x);
            }
        } else {
            mMinStack.push(x);
        }
    }
    
    public void pop() {
        int x = mStack.pop();
        if (mMinStack.size() != 0) {
            if (x == mMinStack.peek()) {
                mMinStack.pop();
            }
        }
    }
    
    public int top() {
        return mStack.peek();
    }
    
    public int getMin() {
        return mMinStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */