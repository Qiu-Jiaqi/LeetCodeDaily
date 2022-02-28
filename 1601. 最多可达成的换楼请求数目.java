package LeetCodeDaily;

/*
思路：枚举，用二进制1表示该请求满足，0表示不满足。合法请求的条件是每栋楼人数变化为0。
*/
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int res = 0, m = requests.length;
        for (int bit = 0; bit < 1 << m; bit++) {
            // 二进制中1的数目，即满足请求的数目
            int count = Integer.bitCount(bit);
            // 若已有答案大于等于当前枚举状态的满足请求数，跳过
            if (res >= count) {
                continue;
            }
            // 记录每栋楼的人数变化
            int[] record = new int[n];
            // 记录人数减少的楼栋数
            int flag = 0;
            for (int i = 0; i < m; i++) {
                // 每次左移与1相与，为1则表示当前请求需要满足
                if ((bit >> i & 1) == 1) {
                    // 当前楼有人搬出，且原来变化人数为0
                    if (--record[requests[i][0]] == -1) {
                        flag--;
                    }
                    // 当前楼有人搬入，且原来为-1（即已有1人搬出），则+1后恢复人数变化为0
                    if (++record[requests[i][1]] == 0) {
                        flag++;
                    }
                }
            }
            // 若人数减少的楼数为0，则增加的同样为0
            if (flag == 0) {
                res = count;
            }
        }
        return res;
    }
}