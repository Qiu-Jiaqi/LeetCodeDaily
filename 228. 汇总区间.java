package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

/*
思路：也是记录进入循环前的下标值，然后比较，看看有没有进了循环
*/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            s.setLength(0);
            s.append(nums[i]);
            int k = i;
            for (int j = i + 1; j < nums.length && nums[j] == nums[j - 1] + 1; j++) {
                k = j;
            }
            if (i != k) {
                s.append("->").append(nums[k]);
                i = k;
            }
            res.add(s.toString());
        }
        return res;
    }
}