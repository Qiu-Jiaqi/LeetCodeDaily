package LeetCodeDaily;

/*
思路：比N皇后1简单，还不用构建，只要数数
*/
class Solution {
    private int res;

    public int totalNQueens(int n) {
        backTrack(new int[n], 0);
        return res;
    }

    private void backTrack(int[] queens, int cur) {
        if (cur == queens.length) {
            res++;
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            if (!isVaild(queens, cur, col)) {
                continue;
            }
            queens[cur] = col;
            backTrack(queens, cur + 1);
        }
    }

    private boolean isVaild(int[] queens, int row, int col) {
        for (int r = row - 1, left = col - 1, right = col + 1; r >= 0; r--, left--, right++) {
            if (queens[r] == col || queens[r] == left || queens[r] == right) {
                return false;
            }
        }
        return true;
    }
}
