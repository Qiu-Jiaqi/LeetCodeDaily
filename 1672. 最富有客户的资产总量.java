package LeetCodeDaily;

import java.util.Arrays;

/*
思路：过于简单
*/
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }
}