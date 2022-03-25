package LeetCodeDaily;

/*
思路：回溯，从起点（1）到终点（2）需要走过每个不为路障（-1）的格子
        先遍历一次，找出起点，同时记录下需要走多少步，然后对起点开始回溯
*/
class Solution {
    private int res;
    private int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    private int sum;

    public int uniquePathsIII(int[][] grid) {
        int sr = 0, sc = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                sum += grid[i][j] != -1 ? 1 : 0;
            }
        }
        backTrack(grid, sr, sc, 1);
        return res;
    }

    private void backTrack(int[][] grid, int r, int c, int cnt) {
        // 越界 或 遇到路障，返回
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) {
            return;
        } else if (grid[r][c] == 2) {
            // 到达终点，若走的步数等于记录的需要走的步数，路径数+1，否则返回
            if (cnt == sum) {
                res++;
            }
            return;
        }
        // 把当前点先设置为路障
        grid[r][c] = -1;
        for (int[] d : dir) {
            backTrack(grid, r + d[0], c + d[1], cnt + 1);
        }
        // 复原
        grid[r][c] = 0;
    }
}
