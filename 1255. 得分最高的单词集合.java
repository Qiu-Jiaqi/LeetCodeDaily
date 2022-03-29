package LeetCodeDaily;

/*
思路：位压缩回溯
*/
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] map = new int[26], curMap = new int[26];
        // 统计字母表letters中各字母个数
        for (char ch : letters) {
            map[ch - 'a']++;
        }
        int res = 0;
        for (int i = 1; i < 1 << words.length; i++) {
            // 每次判断单词是否能拼写的字母表
            System.arraycopy(map, 0, curMap, 0, 26);
            int cur = 0;
            // 右移j位为0则说明后面都是0，cur用于记录此次分数，拼不出的时候置为负数退出此次循环
            for (int j = 0; i >> j > 0 && cur >= 0; j++) {
                // 当前位为0，说明没有选取
                if (((i >> j) & 1) == 0) {
                    continue;
                }
                for (char ch : words[j].toCharArray()) {
                    // 字母表中有字母不足，cur置为负数，退出此次状态选择
                    if (--curMap[ch - 'a'] < 0) {
                        cur = -1;
                        break;
                    }
                    cur += score[ch - 'a'];
                }
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
