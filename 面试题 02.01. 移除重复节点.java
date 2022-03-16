package LeetCodeDaily;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
 * 思路：哈希表
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (ListNode cur = head, pre = null; cur != null; cur = cur.next) {
            if (!set.add(cur.val)) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
        }
        return head;
    }
}