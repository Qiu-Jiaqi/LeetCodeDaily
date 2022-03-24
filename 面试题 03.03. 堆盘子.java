package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
思路：用一个列表保存多个栈
*/
class StackOfPlates {
    private int cap;
    private List<Deque<Integer>> stackList;
    private Deque<Integer> stack;

    public StackOfPlates(int cap) {
        this.cap = cap;
        this.stackList = new ArrayList<>();
    }

    public void push(int val) {
        if (cap == 0) {
            return;
        }
        if (stackList.size() == 0 || stackList.get(stackList.size() - 1).size() == cap) {
            stackList.add(new LinkedList<>());
        }
        stack = stackList.get(stackList.size() - 1);
        stack.offer(val);
    }

    public int pop() {
        return popAt(stackList.size() - 1);
    }

    public int popAt(int index) {
        if (index < 0 || index >= stackList.size()) {
            return -1;
        }
        stack = stackList.get(index);
        int pop = stack.pollLast();
        if (stack.isEmpty()) {
            stackList.remove(index);
        }
        return pop;
    }
}
