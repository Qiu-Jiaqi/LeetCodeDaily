package LeetCodeDaily;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
 * 思路：用两段链表保存，最后连起来
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode minHead = new ListNode(0), maxHead = new ListNode(0);
        ListNode minCur = minHead, maxCur = maxHead;
        for (; head != null; head = head.next) {
            if (head.val < x) {
                minCur.next = head;
                minCur = minCur.next;
            } else {
                maxCur.next = head;
                maxCur = maxCur.next;
            }
        }
        maxCur.next = null;
        minCur.next = maxHead.next;
        return minHead.next;
    }
}
