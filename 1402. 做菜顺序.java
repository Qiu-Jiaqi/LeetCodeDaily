package LeetCodeDaily;

import java.util.Arrays;

/*
思路：贪心：每次先选最满意的，再把前面的都加一遍，每次加的都是前面所有已选的和当前选的，所以当sum>0都可以继续
*/
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0, sum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum <= 0) {
                return res;
            }
            res += sum;
        }
        return res;
    }
}