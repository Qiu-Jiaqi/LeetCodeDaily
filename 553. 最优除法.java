package LeetCodeDaily;

/*
思路：数学题。
    要使除法结果最大，则被除数最大，除数最小，而题目中规定元素大小为[2,1000]，分子做的除法越少则分子越大，分母做的除法越多则越小。
*/
class Solution {
    public String optimalDivision(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return String.valueOf(nums[0]);
        } else if (len == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder res = new StringBuilder();
        res.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < len; i++) {
            res.append("/" + nums[i]);
        }
        res.append(")");
        return res.toString();
    }
}