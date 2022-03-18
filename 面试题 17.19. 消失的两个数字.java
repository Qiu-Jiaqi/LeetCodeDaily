package LeetCodeDaily;

/*
思路：第一次遍历，把存在的数字的下标-1标记为负数，同时求出两个缺失数字的sum
    第二次遍历，找到正数，然后用sum-i即求出，若不存在正数，说明缺失的两个是数组长度外的最大两个数
*/
class Solution {
    public int[] missingTwo(int[] nums) {
        int sum = (1 + nums.length + 2) * (nums.length + 2) / 2;
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            sum -= num;
            if (num <= nums.length) {
                nums[num - 1] *= -1;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                return new int[] { i, sum - i };
            }
        }
        return new int[] { nums.length + 1, nums.length + 2 };
    }
}
