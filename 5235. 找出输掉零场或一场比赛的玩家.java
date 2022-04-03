package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
思路：哈希表记录
*/
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lose = new HashMap<>();
        for (int[] match : matches) {
            lose.put(match[0], lose.getOrDefault(match[0], 0));
            lose.put(match[1], lose.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>(), list1 = new ArrayList<>();
        for (Entry<Integer, Integer> entry : lose.entrySet()) {
            if (entry.getValue() == 0) {
                list0.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                list1.add(entry.getKey());
            }
        }
        Collections.sort(list0);
        Collections.sort(list1);
        res.add(list0);
        res.add(list1);
        return res;
    }
}
