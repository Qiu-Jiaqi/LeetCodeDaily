package LeetCodeDaily;

/*
思路：判断一下左边界、右边界，然后往右的判断与右边是否成V字型，往左的判断与左边是否成V字形，这四种情况返回-1
    剩下情况就转到下一行判断，-1往左，1往右，到底就直接返回此时的下标
*/
class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs(grid, 0, i);
        }
        return res;
    }

    public int dfs(int[][] grid, int m, int n) {
        // 到底，返回此时下标
        if (m == grid.length)
            return n;
        // 左右边界
        if (n == 0 && grid[m][n] == -1 || n == grid[0].length - 1 && grid[m][n] == 1)
            return -1;
        // v字形
        if (grid[m][n] == -1 && grid[m][n - 1] == 1 || grid[m][n] == 1 && grid[m][n + 1] == -1)
            return -1;
        return grid[m][n] == -1 ? dfs(grid, m + 1, n - 1) : dfs(grid, m + 1, n + 1);
    }
}