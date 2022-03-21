package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
思路：N皇后，又做一遍，检查是否合法的时候检查之前的行就行，三叉型往上
*/
class Solution {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        backTrack(new int[n], 0);
        return res;
    }

    private void backTrack(int[] queens, int cur) {
        if (cur == queens.length) {
            res.add(createBoard(queens));
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
        for (int i = row - 1, left = col - 1, right = col + 1; i >= 0; i--, left--, right++) {
            if (queens[i] == col || queens[i] == left || queens[i] == right) {
                return false;
            }
        }
        return true;
    }

    private List<String> createBoard(int[] queens) {
        List<String> board = new ArrayList<>();
        for (int queen : queens) {
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queen] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}