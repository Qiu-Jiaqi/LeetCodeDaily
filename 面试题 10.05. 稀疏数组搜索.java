package LeetCodeDaily;

/*
思路：
    1. 直接遍历
    2. 二分：就是多了一个为空字符串的判断，然后往两边找到第一个不为空的lmid和rmid
            判断是否在这left - lmid 和 rmid - right两段之中，把mid改为这个数，否则不存在任何一段中返回-1
*/
class Solution {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ("".equals(words[mid])) {
                int lmid = mid, rmid = mid;
                while (lmid >= left && "".equals(words[lmid])) {
                    lmid--;
                }
                while (rmid <= right && "".equals(words[rmid])) {
                    rmid++;
                }
                if (lmid >= left && s.compareTo(words[lmid]) <= 0) {
                    mid = lmid;
                } else if (rmid <= right && s.compareTo(words[rmid]) >= 0) {
                    mid = rmid;
                } else {
                    return -1;
                }
            }
            if (s.equals(words[mid])) {
                return mid;
            } else if (s.compareTo(words[mid]) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
