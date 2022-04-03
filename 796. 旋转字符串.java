package LeetCodeDaily;

/*
思路：重叠判断就好
*/
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && s.concat(s).contains(goal);
    }
}