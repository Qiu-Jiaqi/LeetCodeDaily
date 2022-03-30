package LeetCodeDaily;

/*
思路：好像做过了，就异或获得本位，与获得进位
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