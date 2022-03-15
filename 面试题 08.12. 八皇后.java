package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
思路：回溯法，N皇后问题基础上加入了对角线的判断
*/
class Solution {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> lefts = new HashSet<>();
        Set<Integer> rights = new HashSet<>();
        backTrack(new int[n], 0, cols, lefts, rights);
        return res;
    }

    private void backTrack(int[] queens, int cur_row, Set<Integer> cols, Set<Integer> lefts, Set<Integer> rights) {
        if (cur_row == queens.length) {
            res.add(createBoard(queens));
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            if (cols.contains(col) || lefts.contains(cur_row + col) || rights.contains(cur_row - col)) {
                continue;
            }
            queens[cur_row] = col;
            cols.add(col);
            lefts.add(cur_row + col);
            rights.add(cur_row - col);
            backTrack(queens, cur_row + 1, cols, lefts, rights);
            cols.remove(col);
            lefts.remove(cur_row + col);
            rights.remove(cur_row - col);
        }
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
