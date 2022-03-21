package LeetCodeDaily;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
 * 思路：就正常模拟加法，链表还是倒置存放，方便加
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int r = 0;
        while (l1 != null || l2 != null || r != 0) {
            int sum = r;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            r = sum / 10;
            cur = cur.next;
        }
        return res.next;
    }
}
