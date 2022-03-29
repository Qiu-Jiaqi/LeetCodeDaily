package LeetCodeDaily;

/*
思路：滑动窗口，保证窗口里不为当前查找的字母最多为k，超过k则移动left到最近的不为当前查找字母的下一个
*/
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutive(answerKey, k, 'T'), maxConsecutive(answerKey, k, 'F'));
    }

    private int maxConsecutive(String answerKey, int k, char key) {
        int res = 0;
        for (int left = 0, right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != key && k-- <= 0) {
                while (answerKey.charAt(left) == key) {
                    left++;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
