package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

// 考虑不全了，只能过一半多的测试用例，9999，10000，100001，这些情况，还有各种奇怪情况，1800，个位数，罢了，太难了。
/* class Solution {
    public String nearestPalindromic(String n) {
        StringBuilder res = new StringBuilder();
        int mid = n.length() / 2;
        boolean odd = (n.length() & 1) == 1;
        StringBuilder s = new StringBuilder(n.substring(0, mid));
        res.append(s);
        if (odd) {
            res.append(n.charAt(mid));
        }
        res.append(s.reverse());
        if (n.equals(res.toString())) {
            if (odd) {
                int mid_num = n.charAt(mid) - '0';
                mid_num = Math.abs(mid_num - 1);
                res.setCharAt(mid, (char) (mid_num + '0'));
            } else {
                res.setLength(0);
                int left_num = Integer.valueOf(n.substring(0, mid));
                left_num--;
                res.append(left_num);
                s.setLength(0);
                s.append(left_num);
                res.append(s.reverse());
            }
        }
        return res.toString();
    }
} */

class Solution {
    public String nearestPalindromic(String n) {
        long selfNumber = Long.parseLong(n), ans = -1;
        List<Long> candidates = getCandidates(n);
        for (long candidate : candidates) {
            if (candidate != selfNumber) {
                if (ans == -1 ||
                        Math.abs(candidate - selfNumber) < Math.abs(ans - selfNumber) ||
                        Math.abs(candidate - selfNumber) == Math.abs(ans - selfNumber) && candidate < ans) {
                    ans = candidate;
                }
            }
        }
        return Long.toString(ans);
    }
    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<Long>() {
            {
                add((long) Math.pow(10, len - 1) - 1);
                add((long) Math.pow(10, len) + 1);
            }
        };
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuffer sb = new StringBuffer();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(len & 1));
            String candidate = sb.toString();
            candidates.add(Long.parseLong(candidate));
        }
        return candidates;
    }
}