package LeetCodeDaily;

/*
思路：把N的i到j部分置0，然后M左移i位相加
*/
class Solution {
    public int insertBits(int N, int M, int i, int j) {
        for (int index = i; index <= j; index++) {
            if (((N >> index) & 1) == 1) {
                N ^= 1 << index;
            }
        }
        return N + (M << i);
    }
}
