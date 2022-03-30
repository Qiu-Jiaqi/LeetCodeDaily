package LeetCodeDaily;

/*
思路：不断消去最右边的1
*/
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}
