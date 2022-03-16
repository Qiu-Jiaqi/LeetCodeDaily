package LeetCodeDaily;

/*
思路：开额外空间的就不写了，先上下翻转，然后对角线翻转
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] ^= matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[n - 1 - i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
    }
}
