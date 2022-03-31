package LeetCodeDaily;

/*
思路：只需考虑最小值和最大值，最大值-k 和 最小值+k 之间的大小关系
*/
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (max - k - min - k) < 0 ? 0 : max - k - min - k;
    }
}
