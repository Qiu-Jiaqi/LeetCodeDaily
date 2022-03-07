package LeetCodeDaily;

/*
思路：%7、/7，注意负数即可，先转换成正数计算，若是负数最后添加'-'
*/
class Solution {
    public String convertToBase7(int num) {
        if (num > -7 && num < 7) {
            return String.valueOf(num);
        }
        StringBuilder res = new StringBuilder();
        for (int i = Math.abs(num); i != 0; i /= 7) {
            res.append(i % 7);
        }
        if (num < 0) {
            res.append('-');
        }
        return res.reverse().toString();
    }
}