package LeetCodeDaily;

/*
思路：暴力法，单个元素的不用计算。
*/
class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        // 子集起点，不用最后一个元素
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i], max = nums[i];
            // 子集终点
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                res += max - min;
            }
        }
        return res;
    }
}