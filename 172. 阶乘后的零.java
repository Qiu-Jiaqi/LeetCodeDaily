package LeetCodeDaily;

/*
思路：昨天刚做了，看有多少个因数5
*/
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
