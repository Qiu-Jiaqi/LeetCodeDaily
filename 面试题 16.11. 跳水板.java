package LeetCodeDaily;

/*
思路：先关注shorter，可能的情况有0个到k个，对应longer就是k个到0个，所以数组长度是k+1
        可以先shorter * k，然后每次 - shoter + longer，就是每次加上两者的差值 longer - shorter；
        当然反过来也可以，先longer * k，然后就是每次减去两者之差
        再考虑 k == 0 和 shorter == longer的特殊情况
*/
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[] {};
        }
        if (shorter == longer) {
            return new int[] { shorter * k };
        }
        int[] res = new int[k + 1];
        int sum = shorter * k, diff = longer - shorter;
        for (int i = 0; i <= k; i++) {
            res[i] = sum;
            sum += diff;
        }
        return res;
    }
}