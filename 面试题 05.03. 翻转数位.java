package LeetCodeDaily;

/*
思路：滑动窗口，保证窗口内的0个数最多为1
*/
class Solution {
    public int reverseBits(int num) {
        int res = 0;
        // low 低位边界，high 高位边界，zeroIndex 记录0位的下标，-1表示还没记录
        for (int low = 0, high = 0, zeroIndex = -1; high < 32; high++) {
            // 遇到0时
            if (((num >> high) & 1) == 0) {
                // 若不为第一次记录，则说明是第二个0，低位边界low直接跳到上一个0的高一位
                if (zeroIndex != -1) {
                    low = zeroIndex + 1;
                }
                // 更新0位的下标
                zeroIndex = high;
            }
            // 更新答案
            res = Math.max(res, high - low + 1);
        }
        return res;
    }
}
