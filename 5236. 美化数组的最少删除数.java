package LeetCodeDaily;

/*
思路：贪心，偶数下标不符合假删除，把下一个下标当偶数，若符合就i+2到下一个偶数下标
        昨天写的模拟过程，直接超时
*/
class Solution {
    public int minDeletion(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res++;
            } else {
                i++;
            }
        }
        return (nums.length - res) % 2 == 0 ? res : res + 1;
    }
}
