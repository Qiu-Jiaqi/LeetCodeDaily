package LeetCodeDaily;

import java.util.Arrays;

/* 
思路：
    每张不为'.'的牌，状态与初始相同，只需把'.'的状态确定，在最左边插入L，最右边插入R后，'.'的情况有四种：L与L、R与R、L与R、R与L之间。
    L与R：不受力，不改变，仍为'.'
    L与L、R与R：全变为L或R
    R与L：双指针往中间靠，左边变R，右边变L，相遇时退出循环
*/
class Solution {
    public String pushDominoes(String dominoes) {
        // 在最左边插入L，最右边插入R
        StringBuilder str = new StringBuilder(dominoes);
        str.insert(0, 'L');
        str.append('R');
        for (int left = 0, right = 1; right < str.length(); left = right, right++) {
            // 跳过'.'
            while (str.charAt(right) == '.')
                right++;
            // 若两个字母之间没有'.'
            if (right == left + 1)
                continue;
            char l = str.charAt(left), r = str.charAt(right);
            // 若左边为L，右边为R，不需要改变
            if (l == 'L' && r == 'R')
                continue;
            // 若两字母相同，则中间的'.'都是该字母
            if (l == r) {
                char[] c = new char[right - left - 1];
                Arrays.fill(c, l);
                str.replace(left + 1, right, String.valueOf(c));
            } else {
                // 否则左边为R，右边为L，用双指针往中间靠
                for (int i = left + 1, j = right - 1; i < j; i++, j--) {
                    str.setCharAt(i, 'R');
                    str.setCharAt(j, 'L');
                }
            }
        }
        // 去除插入的首尾字母
        return str.substring(1, str.length() - 1);
    }
}