package LeetCodeDaily;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
 * 思路：双指针，前面的先跑k步
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }
        return head.val;
    }
}
