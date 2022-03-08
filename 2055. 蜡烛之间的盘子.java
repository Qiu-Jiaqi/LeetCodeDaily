package LeetCodeDaily;

/*
思路：前缀和preSum保存盘子数，left保存当前位置往左的第一根蜡烛下标，right保存当前位置往右的第一根蜡烛下标
*/
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] preSum = new int[s.length()], left = new int[s.length()], right = new int[s.length()];
        for (int i = 0, j = s.length() - 1, sum = 0, l = -1, r = -1; i < s.length(); i++, j--) {
            sum += s.charAt(i) == '*' ? 1 : 0;
            l = s.charAt(i) == '|' ? i : l;
            r = s.charAt(j) == '|' ? j : r;
            preSum[i] = sum;
            left[i] = l;
            right[j] = r;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            // 找蜡烛，左端点往右，右端点往左
            int l = right[queries[i][0]], r = left[queries[i][1]];
            // 若不存在或超出范围
            if (l == -1 || l > queries[i][1] || r == -1 || r < queries[i][0]) {
                continue;
            }
            res[i] = preSum[r] - preSum[l];
        }
        return res;
    }
}