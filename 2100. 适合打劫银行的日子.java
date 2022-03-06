package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

/*
思路：用两个数组分别记录下当前位置连续非递增（非递减）第几个
*/
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        // 此时不存在下标，左右两边有time个元素
        if (security.length < 2 * time + 1) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        // time为0时，任意一天皆可
        if (time == 0) {
            for (int i = 0; i < security.length; i++) {
                res.add(i);
            }
            return res;
        }
        int[] not_asc = new int[security.length];
        int[] not_desc = new int[security.length];
        for (int i = 1; i < security.length; i++) {
            not_asc[i] = security[i] > security[i - 1] ? 0 : not_asc[i - 1] + 1;
            not_desc[i] = security[i] < security[i - 1] ? 0 : not_desc[i - 1] + 1;
        }
        for (int i = time; i < security.length - time; i++) {
            // 当前点判断左边的非递增，右端点判断非递减
            if (not_asc[i] >= time && not_desc[i + time] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}