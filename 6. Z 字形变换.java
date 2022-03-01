package LeetCodeDaily;

/*
思路：模拟，每行用一个StringBuilder添加，最后再逐行加入。
*/
class Solution {
    public String convert(String s, int numRows) {
        // 当只有一行时，或字符串长度比行数少，直接返回s
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        // 注意这里不要用foreach初始化
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        // 用index记录当前行，dir记录当前移动方向
        int index = 0, dir = -1;
        for (char c : s.toCharArray()) {
            rows[index].append(c);
            if (index == 0 || index == numRows - 1) {
                dir = -dir;
            }
            index += dir;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}