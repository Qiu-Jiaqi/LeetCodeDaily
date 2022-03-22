package LeetCodeDaily;

/*
思路：取出偶数位右移一位，奇数位左移一位
*/
class Solution {
    public int exchangeBits(int num) {
        return (num & 0xaaaaaaaa) >> 1 | (num & 0x55555555) << 1;
    }
}
