package LeetCodeDaily;

/*
思路：StringBuilder或char数组操作
*/

/* class Solution {
    public String replaceSpaces(String S, int length) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(S.charAt(i));
            }
        }
        return res.toString();
    }
} */
class Solution {
    public String replaceSpaces(String S, int length) {
        int space = 0;
        for (int i = 0; i < length; i++) {
            space += S.charAt(i) == ' ' ? 1 : 0;
        }
        char[] array = new char[length + 2 * space];
        for (int i = 0, index = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = S.charAt(i);
            }
        }
        return new String(array);
    }
}