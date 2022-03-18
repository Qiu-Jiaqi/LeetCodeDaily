package LeetCodeDaily;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
 * 思路：让链表对齐，跳过长链表的前部分。
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        // 进行对齐的前置操作，相等或其中一个为null退出循环
        while (a != b && a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        // 长度相等时发生的情况，要么找到相交点，要么两者走到尾部null
        if (a == b) {
            return a;
        }
        // 不为null的则为长链表，走完剩下的步数
        while (a != null) {
            a = a.next;
            headA = headA.next;
        }
        while (b != null) {
            b = b.next;
            headB = headB.next;
        }
        // 当相等时退出循环返回，即使不存在，也会到达最后的null
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
