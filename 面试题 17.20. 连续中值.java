package LeetCodeDaily;

import java.util.PriorityQueue;

/*
思路：对前半部分构造最大堆left，后半部分构造最小堆right，保证容量left - right <= 1 则：
    奇数时，最大堆最大值即为答案；偶数时，最大堆最大值+最小堆最小值的和除2为答案
    每次加入元素时，任选一个堆的堆顶元素比较大小后加入即可，开始时为空直接加入左边的最大堆
    每次查找中值时，先对两个堆进行平衡，保证容量大小满足left - right <= 1
*/
class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || left.peek() > num) {
            left.offer(num);
        } else {
            right.offer(num);
        }
    }

    public double findMedian() {
        resize();
        return left.size() > right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
    }

    private void resize() {
        while (left.size() - right.size() > 1) {
            right.offer(left.poll());
        }
        while (right.size() - left.size() >= 1) {
            left.offer(right.poll());
        }
    }
}
