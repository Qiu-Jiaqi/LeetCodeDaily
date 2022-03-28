package LeetCodeDaily;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
思路：偷懒，纯纯stream
*/
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> list1 = set1.stream().filter(t -> !set2.contains(t)).collect(Collectors.toList());
        List<Integer> list2 = set2.stream().filter(t -> !set1.contains(t)).collect(Collectors.toList());
        return Arrays.asList(list1, list2);
    }
}
