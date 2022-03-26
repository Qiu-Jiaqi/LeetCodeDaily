package LeetCodeDaily;

import java.util.Deque;
import java.util.LinkedList;

/*
思路：用栈
*/
class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String s : ops) {
            if ("+".equals(s)) {
                int last = stack.poll();
                int cur = last + stack.peek();
                res += cur;
                stack.push(last);
                stack.push(cur);
            } else if ("D".equals(s)) {
                int cur = stack.peek() * 2;
                res += cur;
                stack.push(cur);
            } else if ("C".equals(s)) {
                res -= stack.peek();
                stack.poll();
            } else {
                int cur = Integer.valueOf(s);
                res += cur;
                stack.push(cur);
            }
        }
        return res;
    }
}