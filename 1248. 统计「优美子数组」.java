package LeetCodeDaily;

/*
思路：记录下奇数数量的个数
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddNum = 0, res = 0;
        int[] cnt = new int[nums.length + 1];
        cnt[oddNum] = 1;
        for (int i = 0; i < nums.length; i++) {
            oddNum += nums[i] & 1;
            res += oddNum >= k ? cnt[oddNum - k] : 0;
            cnt[oddNum]++;
        }
        return res;
    }
}
