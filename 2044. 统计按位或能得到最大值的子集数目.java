package LeetCodeDaily;

/*
思路：回溯
*/
class Solution {
    private int res = 0;
    private int max = Integer.MIN_VALUE;

    public int countMaxOrSubsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            backTrack(nums, i, 0);
        }
        return res;
    }

    private void backTrack(int[] nums, int index, int value) {
        value |= nums[index];
        if (value > max) {
            max = value;
            res = 1;
        } else if (value == max) {
            res++;
        }
        for (int i = index + 1; i < nums.length; i++) {
            backTrack(nums, i, value);
        }
    }
}