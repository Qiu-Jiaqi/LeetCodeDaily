package LeetCodeDaily;

import java.util.PriorityQueue;

/*
思路：两个堆，保持大小关系就好，做过类似的
        max是最小堆，存大数
        min是最大堆，存小数
*/
class MedianFinder {
    private int size = 0;
    private PriorityQueue<Integer> max = new PriorityQueue<>();
    private PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {

    }

    public void addNum(int num) {
        size++;
        if (max.size() == 0 || max.peek() <= num) {
            max.offer(num);
        } else {
            min.offer(num);
        }
    }

    public double findMedian() {
        resize();
        if ((size & 1) == 0 && size != 0) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }

    private void resize() {
        while (max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
        while (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }
}
