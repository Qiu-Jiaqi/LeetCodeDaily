package LeetCodeDaily;

/*
思路：贪心
*/
class Solution {
    public int convertTime(String current, String correct) {
        int diff = parseTime(correct) - parseTime(current);
        int res = 0;
        int[] array = { 60, 15, 5, 1 };
        for (int d : array) {
            res += diff / d;
            diff %= d;
        }
        return res;
    }

    private int parseTime(String time) {
        String[] sp = time.split(":");
        return Integer.valueOf(sp[0]) * 60 + Integer.valueOf(sp[1]);
    }
}
