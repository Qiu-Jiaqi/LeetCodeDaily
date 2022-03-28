package LeetCodeDaily;

/*
思路：动态规划，只需保存前两个结果
*/
class Solution {
    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int c = Math.max(b, a + num);
            a = b;
            b = c;
        }
        return b;
    }
}