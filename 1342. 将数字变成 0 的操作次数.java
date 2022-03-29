package LeetCodeDaily;

/*
思路：模拟
*/
class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num--;
            }
            res++;
        }
        return res;
    }
}
