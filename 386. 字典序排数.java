package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            res.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num >= n || num % 10 == 9) {
                    num /= 10;
                }
                num++;
            }
        }
        return res;
    }
}
