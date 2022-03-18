package LeetCodeDaily;

import java.util.Stack;

/*
思路：两个栈，一个只保存小于等于栈顶的值，注意pop比较两者时，直接用minStack.peek()将会比较Integer
*/
class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || minStack.peek() >= node) {
            minStack.push(node);
        }
    }

    public void pop() {
        if (stack.pop() == getMin()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}