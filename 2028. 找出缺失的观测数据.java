package LeetCodeDaily;

import java.util.Arrays;

/*
思路：纯数学题，在平均数的基础上，再用余数逐个+1就好
*/
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, sum = (m + n) * mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum > 6 * n || sum < n) {
            return new int[] {};
        }
        int[] res = new int[n];
        int avg = sum / n, r = sum % n;
        Arrays.fill(res, avg);
        for (int i = 0; r > 0; r--) {
            res[i++]++;
        }
        return res;
    }
}
