package LeetCodeDaily;

/*
思路：最大子序和，简单的动态规划，每次sum<0就可以重来了
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }
}