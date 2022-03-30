package LeetCodeDaily;

/*
思路：
    左神视频学的，先用0异或获取到a ^ b，因为a不等于b，a ^ b必不为0，必有一位为1，找出最右的1，用这位把数组的数分为两组，则：
    a和b必不在同一组，再用0与其中一组异或，得到a或b，和a ^ b异或得到另一个
    技巧：n & (~n + 1)可得到最右边的1;
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0, one = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int rightOne = xor & (~xor + 1);
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                one ^= num;
            }
        }
        return new int[] { one, xor ^ one };
    }
}
