package LeetCodeDaily;

/*
思路：有重复数字应该是不能二分吧
*/
class Solution {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}