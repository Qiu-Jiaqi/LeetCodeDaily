package LeetCodeDaily;

/*
思路：用一个min记录遍历过的最小值
*/
class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                res = Math.max(res, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return res;
    }
}