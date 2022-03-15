package LeetCodeDaily;

/*
思路：双指针
*/
class Solution {
    public String compressString(String S) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int k = i;
            for (int j = i + 1; j < S.length() && S.charAt(i) == S.charAt(j); j++) {
                k = j;
            }
            res.append(S.charAt(i)).append(k - i + 1);
            i = k;
        }
        return res.length() < S.length() ? res.toString() : S;
    }
}
