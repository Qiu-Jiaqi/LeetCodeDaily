package LeetCodeDaily;

/*
思路：模拟换行
*/
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1, width = 0;
        for (char ch : s.toCharArray()) {
            width += widths[ch - 'a'];
            if (width > 100) {
                line++;
                width = widths[ch - 'a'];
            }
        }
        return new int[] { line, width };
    }
}