package LeetCodeDaily;

/*
思路：双指针，接雨水嘛之前做过，就是哪边更低就移动哪边，两个变量记录两边的最高
*/
class Solution {
    public int trap(int[] height) {
        int res = 0;
        for (int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0; left < right;) {
            if (height[left] < height[right]) {
                res += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                res += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return res;
    }
}