package LeetCodeDaily;

/*
思路：前缀和，然后找出四个点，注意判断即可，小的不可少于0，用max，大的不可超出，用min
*/
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = img[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = Math.max(0, i - 1), down = Math.min(m - 1, i + 1);
                int left = Math.max(0, j - 1), right = Math.min(n - 1, j + 1);
                int cnt = (down - up + 1) * (right - left + 1);
                int sum = preSum[down + 1][right + 1] - preSum[down + 1][left] - preSum[up][right + 1] + preSum[up][left];
                img[i][j] = sum / cnt;
            }
        }
        return img;
    }
}
