package LeetCodeDaily;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*
 * 思路：记录前一个，双指针冲
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode pre = null, cur = head; cur != null; cur = cur.next) {
            ListNode k = cur;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (cur != k) {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
            } else {
                pre = cur;
            }
        }
        return head;
    }
}
