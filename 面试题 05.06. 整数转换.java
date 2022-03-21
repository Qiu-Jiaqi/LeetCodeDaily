package LeetCodeDaily;

/*
思路：异或后统计1的位数，可用n &= (n-1)消去最右边的1来统计，这里直接调用API了
*/
class Solution {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}