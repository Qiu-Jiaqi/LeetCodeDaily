package LeetCodeDaily;

/*
思路：偶数与其右移1位的1个数相同，而奇数只需+1
*/
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}