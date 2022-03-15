package LeetCodeDaily;

import java.util.Scanner;

/*
2. 喊7
    有N个人，从1开始循环报数，每到7的倍数或数字中含有7，则喊‘过’，报数到多少并不知道
    输入：给定N个数字，这N个数字为这N个人喊‘过’的次数，但是是打乱的，要你输出每个人正确的喊‘过’次数
    输出：N个人正确的喊‘过’次数
    思路：记录下人数N，统计总喊‘过’次数，然后重新构建喊‘过’次数的数组
*/
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0, sum = 0;
        while (in.hasNextInt()) {
            num++;
            sum += in.nextInt();
        }
        int[] array = new int[num];
        for (int i = 1; sum > 0; i++) {
            if (isSeven(i)) {
                array[(i - 1) % num]++;
                sum--;
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        in.close();
    }

    public static boolean isSeven(int n) {
        if (n % 7 == 0) {
            return true;
        }
        while (n != 0) {
            if (n % 10 == 7) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
