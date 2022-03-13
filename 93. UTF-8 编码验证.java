package LeetCodeDaily;

/*
思路：字节为1-4，而1个字节时不需要前导1，每次统计1的数量，然后若大于4或等于1则false，若超出数组长度也是false
        然后判断之后的len - 1个，第一位为1，第二位为0
*/
class Solution {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length;) {
            int len = 0;
            for (int j = 7; j >= 0 && (data[i] >> j & 1) == 1; j--) {
                len++;
            }
            if (len > 4 || len == 1 || i + len - 1 >= data.length) {
                return false;
            }
            for (int j = i + 1; j < i + len; j++) {
                if ((data[j] >> 7 & 1) != 1 || (data[j] >> 6 & 1) != 0) {
                    return false;
                }
            }
            i = len == 0 ? i + 1 : i + len;
        }
        return true;
    }
}
