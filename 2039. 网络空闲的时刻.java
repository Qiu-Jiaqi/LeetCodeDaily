package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
思路：构建图，从0开始广度遍历，得出每个数据服务器到0主服务器的距离，同时计算答案
*/
class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<Integer>[] g = new List[patience.length];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        // 构建图
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        int res = 0;
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        // 记录是否遍历
        boolean[] record = new boolean[g.length];
        record[0] = true;
        // 每次当前层遍历完，则距离+1
        for (int dis = 1; !q.isEmpty(); dis++) {
            for (int i = 0, size = q.size(); i < size; i++) {
                for (int cur : g[q.poll()]) {
                    if (record[cur]) {
                        continue;
                    }
                    record[cur] = true;
                    q.offer(cur);
                    // 计算重发的次数
                    int resendTime = (2 * dis - 1) / patience[cur];
                    // 重发次数*间隔秒数 + 来回距离即为所需时间，再加一就是最早空闲的秒数
                    res = Math.max(res, resendTime * patience[cur] + 2 * dis + 1);
                }
            }
        }
        return res;
    }
}
