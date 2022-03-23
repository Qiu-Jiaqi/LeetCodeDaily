package LeetCodeDaily;

/*
思路：一开始以为要构建字典树，看题解发现其实只要想象存在这样一颗字典树即可
*/
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        while (k > 1) {
            int nodes = getNodes(n, cur);
            // k大于当前根节点的子节点数，直接跳过所有，cur往右
            if (k > nodes) {
                k -= nodes;
                cur++;
            } else {
                // k小于等于当前根节点的子节点数，说明在里面，往下寻找
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    // 获取当前根节点的子节点数
    private int getNodes(int n, long cur) {
        int nodes = 0;
        long next = cur + 1;
        while (cur <= n) {
            // 当前层要么是满10叉树，要么是不满，在n处断开
            nodes += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return nodes;
    }
}