package LeetCodeDaily;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
 * 思路：
 * 1. 栈
 * 2. 翻转前半部分，从中间往两边比较是否相等（不想写了）
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            stack.add(cur.val);
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}