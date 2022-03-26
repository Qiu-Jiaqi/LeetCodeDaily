package LeetCodeDaily;

/*
思路：写了几个二进制加法就发现规律了，异或得到本位，相与得到进位，然后一直进行直到进位为0
*/
class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            int r = a & b;
            a ^= b;
            b = r << 1;
        }
        return a;
    }
}
