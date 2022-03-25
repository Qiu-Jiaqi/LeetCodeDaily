package LeetCodeDaily;

/*
思路：用哈希表先记录一次结果的数量，之后遍历猜测数组去算出伪猜对数量（此时包括真正猜对），再减去真正猜对的数量
        用了个字符串去取哈希表的下标
*/
class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2], count = new int[4];
        String s = "RYGB";
        for (char c : solution.toCharArray()) {
            count[s.indexOf(c)]++;
        }
        for (int i = 0; i < guess.length(); i++) {
            char ch1 = guess.charAt(i), ch2 = solution.charAt(i);
            if (ch1 == ch2) {
                res[0]++;
            }
            if (count[s.indexOf(ch1)] > 0) {
                count[s.indexOf(ch1)]--;
                res[1]++;
            }
        }
        res[1] -= res[0];
        return res;
    }
}