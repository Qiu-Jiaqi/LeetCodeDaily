package LeetCodeDaily;

/*
思路：就是统计1 - n 之中有多少对 2 * 5，而2的数量必定多于5，只需统计5的因子数
*/
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
