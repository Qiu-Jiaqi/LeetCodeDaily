package LeetCodeDaily;

/*
思路：用移位取绝对值，用(a + b + |a - b|) / 2 得出
*/
class Solution {
    public int maximum(int a, int b) {
        long sum = (long) a + (long) b;
        long diff = (long) a - (long) b;
        long abs_diff = (diff ^ (diff >> 63)) - (diff >> 63);
        return (int) ((sum + abs_diff) / 2);
    }
}