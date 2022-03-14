package LeetCodeDaily;

/*
思路：分三种情况：
    1.长度差大于1
    2.长度相等（替换操作）
    3.长度差等于1（插入或删除操作）
*/
class Solution {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        // 保证first长度大于second，方便处理
        if (len1 < len2) {
            return oneEditAway(second, first);
        } else if (len1 - len2 > 1) {
            // 长度差大于1，编辑必大于1次
            return false;
        }
        // 记录不相同字符的个数，大于1时即返回false
        int count = 0;
        // 长度相同时，相同下标逐个比较，出现第一个不相等字符时（替换操作），第二个不相等字符时返回false
        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                    // 放里面不用每次循环判断
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        // len1 - len2 == 1时，此时编辑必定为对first的删除操作，即当出现第一个不相等字符时，second下标不变，first下标照常加1
        for (int i = 0, j = 0; i < len1 && j < len2; i++) {
            if (first.charAt(i) != second.charAt(j)) {
                count++;
                if (count > 1) {
                    return false;
                }
                // 跳过j++
                continue;
            }
            j++;
        }
        return true;
    }
}
