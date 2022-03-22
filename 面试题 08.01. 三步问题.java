package LeetCodeDaily;

/*
思路：就是斐波那契数列，注意两个数相加时就要取模了
*/
class Solution {
    public int waysToStep(int n) {
        int a = 1, b = 2, c = 4;
        for (int i = 4; i <= n; i++) {
            int next = ((a + b) % 1000000007 + c) % 1000000007;
            a = b;
            b = c;
            c = next;
        }
        return n == 1 || n == 2 ? n : c;
    }
}
