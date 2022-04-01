package LeetCodeDaily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
思路：哈希表记录出现次数，判断特殊值0，然后从0往两端开始，绝对值最小的开始判断
*/
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if ((map.getOrDefault(0, 0) & 1) != 0) {
            return false;
        }
        List<Integer> list = map.keySet().stream().sorted((a, b) -> Math.abs(a) - Math.abs(b)).collect(Collectors.toList());
        for (int x : list) {
            if (map.get(x) > map.getOrDefault(2 * x, 0)) {
                return false;
            }
            map.put(2 * x, map.getOrDefault(2 * x, 0) - map.get(x));
        }
        return true;
    }
}