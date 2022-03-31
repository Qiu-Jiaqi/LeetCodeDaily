package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

/*
思路：就每位判断
*/
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivisor(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDivisor(int n) {
        for (int i = n; i != 0; i /= 10) {
            int cur = i % 10;
            if (cur == 0 || n % cur != 0) {
                return false;
            }
        }
        return true;
    }
}
