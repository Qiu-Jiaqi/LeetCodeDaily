package LeetCodeDaily;

import java.util.Arrays;
import java.util.Comparator;

/*
思路：就排序，可以用转为集合再重写比较器排序，然后再转为数组
        这里直接复习一下stream的用法
*/
class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.comparing(Integer::bitCount).thenComparing(Comparator.naturalOrder()))
                .mapToInt(Integer::intValue).toArray();
    }
}
