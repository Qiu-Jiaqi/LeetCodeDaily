package LeetCodeDaily;

/*
思路：用哈希表的方法肯定都能想到，看了题解，这个两个long记录的方法确实好，64+64，128位刚好够ASCII码
*/
class Solution {
    public boolean isUnique(String astr) {
        long low = 0, high = 0;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bit = 1L << (c - 64);
                if ((high & bit) != 0) {
                    return false;
                }
                high |= bit;
            } else {
                long bit = 1L << c;
                if ((low & bit) != 0) {
                    return false;
                }
                low |= bit;
            }
        }
        return true;
    }
}
