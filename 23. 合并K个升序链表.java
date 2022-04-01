package LeetCodeDaily;

import java.util.PriorityQueue;

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
 * 思路：前几天刚听了左神说堆，有一个数组几乎有序，即排序后与原位置相差不超过k，也是构建一个k长度的堆，每次进一个出一个，这里只是变成链表
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode res = heap.peek(), cur = res;
        while (!heap.isEmpty()) {
            ListNode temp = heap.poll();
            if (temp.next != null) {
                heap.offer(temp.next);
            }
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }
}
