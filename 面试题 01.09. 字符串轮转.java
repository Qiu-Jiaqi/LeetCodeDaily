package LeetCodeDaily;

/*
思路：自身与自身相连，必定存在旋转后的字串
*/
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String doubleS1 = s1 + s1;
        return doubleS1.contains(s2);
    }
}
