package LeetCodeDaily;

/*
思路：
    利用异或运算取反，0 ^ 1 = 1,1 ^ 1 = 0，与1异或即可取反
    可以把有效位全部置为1，再与原数进行异或即可
    要找到有效位，只需知道最左边1的位置，然后左移1位再减1，即可把有效位全部置为1
    可以用二分法找出最左边的1
*/
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int exp = 4, pos = 1 << exp;
        while (exp-- > 0) {
            if (n >> pos == 0) {
                pos -= 1 << exp;
            } else {
                pos += 1 << exp;
            }
        }
        pos = n >> pos != 0 ? pos : pos - 1;
        int one = (1 << (pos + 1)) - 1;
        return one ^ n;
    }
}