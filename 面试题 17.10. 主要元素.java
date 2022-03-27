package LeetCodeDaily;

/*
思路：摩尔投票法找众数
*/
class Solution {
    public int majorityElement(int[] nums) {
        int cur = -1, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                cur = num;
                cnt++;
            } else {
                cnt += num == cur ? 1 : -1;
            }
        }
        cnt = 0;
        for (int num : nums) {
            if (num == cur) {
                cnt++;
            }
        }
        return cnt > nums.length / 2 ? cur : -1;
    }
}