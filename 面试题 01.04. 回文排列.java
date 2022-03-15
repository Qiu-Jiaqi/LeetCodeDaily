package LeetCodeDaily;

/*
思路：本来想的是要么出现次数全是偶数，要么只有一个出现次数为奇数，写出来就成这样了。
    看了题解，位运算的还是秒啊。
*/
/* class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int[] ht = new int[128];
        for (char c : s.toCharArray()) {
            ht[c] += ht[c] == 0 ? 1 : -1;
        }
        int sum = 0;
        for (int num : ht) {
            sum += num;
        }
        return sum <= 1;
    }
} */
class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        long low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c >= 64) {
                high ^= 1L << (c - 64);
            } else {
                low ^= 1L << c;
            }
        }
        return Long.bitCount(low) + Long.bitCount(high) <= 1;
    }
}
