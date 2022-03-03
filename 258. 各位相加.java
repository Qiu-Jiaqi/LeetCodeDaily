package LeetCodeDaily;

/*
思路：1.模拟。2.找规律
*/
/* class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            for (int i = num; i != 0; i /= 10) {
                sum += i % 10;
            }
            num = sum;
        }
        return num;
    }
} */

class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}