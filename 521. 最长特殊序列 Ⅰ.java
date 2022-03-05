package LeetCodeDaily;

/*
思路：题目蛮怪的，长度长的必定是最长特殊序列，长度相等时只要不相同，就是长度，只有相同时才是-1
*/
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}