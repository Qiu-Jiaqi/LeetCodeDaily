package LeetCodeDaily;

import java.util.PriorityQueue;
import java.util.Queue;

/*
思路：两个栈实现最小堆，不想写了，直接用优先队列了，其实就和那题能获取最小值的栈差不多。
*/
class SortedStack {
    Queue<Integer> queue;

    public SortedStack() {
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        queue.offer(val);
    }

    public void pop() {
        queue.poll();
    }

    public int peek() {
        return isEmpty() ? -1 : queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}