package LeetCodeDaily;

/*
思路：比比看谁能删得多
*/

/* class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0, b = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                a += colors.charAt(i) == 'A' ? 1 : 0;
                b += colors.charAt(i) == 'B' ? 1 : 0;
            }
        }
        return a > b;
    }
} */

class Solution {
    public boolean winnerOfGame(String colors) {
        char cur = 'C';
        int cnt = 0, res = 0;
        for (char ch : colors.toCharArray()) {
            if (ch != cur) {
                cur = ch;
                cnt = 1;
            } else {
                if (++cnt >= 3) {
                    res += ch == 'A' ? 1 : -1;
                }
            }
        }
        return res > 0;
    }
}