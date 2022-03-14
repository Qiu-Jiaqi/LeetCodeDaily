package LeetCodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
思路：哈希表
*/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int temp = j + map.get(list2[j]);
                if (temp < min) {
                    min = temp;
                    res.clear();
                    res.add(list2[j]);
                } else if (temp == min) {
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}