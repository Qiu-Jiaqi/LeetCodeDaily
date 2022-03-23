package LeetCodeDaily;

/*
思路：自己想的是垃圾的老实插入法
*/
/* class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            int index = getIndex(A, B[i], m + i);
            for (int j = m + i; j > index; j--) {
                A[j] = A[j - 1];
            }
            A[index] = B[i];
        }
    }

    private int getIndex(int[] A, int cur, int size) {
        for (int i = 0; i < size; i++) {
            if (A[i] > cur) {
                return i;
            }
        }
        return size;
    }
}
 */

/*
思路：利用有序，从尾部往前插入较大的就行
*/
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int index = m-- + n-- - 1;
        while (m >= 0 || n >= 0) {
            if (n < 0) {
                A[index--] = A[m--];
            } else if (m < 0) {
                A[index--] = B[n--];
            } else {
                A[index--] = A[m] > B[n] ? A[m--] : B[n--];
            }
        }
    }
}