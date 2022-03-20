package LeetCodeDaily;

/*
思路：先计算二维数组前缀和，然后进行固定上下边，找当前的最大连续子序和
*/
class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] preSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = matrix[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        int max = matrix[0][0];
        int[] res = new int[4];
        for (int up = 0; up < n; up++) {
            for (int down = up; down < n; down++) {
                for (int left = 0, right = 0; right < m; right++) {
                    int cur = preSum[down + 1][right + 1] - preSum[down + 1][left] - preSum[up][right + 1]
                            + preSum[up][left];
                    if (cur > max) {
                        max = cur;
                        res[0] = up;
                        res[1] = left;
                        res[2] = down;
                        res[3] = right;
                    }
                    if (cur < 0) {
                        left = right + 1;
                    }
                }
            }
        }
        return res;
    }
}
