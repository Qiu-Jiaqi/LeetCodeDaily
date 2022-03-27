package LeetCodeDaily;

/*
思路：基本数学问题，等差数列求和
*/
class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
