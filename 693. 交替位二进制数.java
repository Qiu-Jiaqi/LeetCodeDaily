package LeetCodeDaily;

/*
思路：相邻两位异或
*/
class Solution {
    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n >>= 1;
        while (n != 0) {
            if (((n & 1) ^ pre) == 0) {
                return false;
            }
            pre = n & 1;
            n >>= 1;
        }
        return true;
    }
}