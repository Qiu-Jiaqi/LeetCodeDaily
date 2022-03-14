package LeetCodeDaily;

/*
思路：1.排序后比较；2.计数
*/
/* class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
} */

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
