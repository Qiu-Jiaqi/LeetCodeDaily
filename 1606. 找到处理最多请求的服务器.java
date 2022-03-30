package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/*
思路：TreeSet free保存空闲服务器编号，PriorityQueue busy保存数组，繁忙服务器编号和处理结束时间
*/
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[1] <= arrival[i]) {
                free.add(busy.poll()[0]);
            }
            if (free.isEmpty()) {
                continue;
            }
            Integer p = free.ceiling(i % k);
            if (p == null) {
                p = free.first();
            }
            requests[p]++;
            busy.offer(new int[] { p, arrival[i] + load[i] });
            free.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                res.add(i);
            }
        }
        return res;
    }
}
