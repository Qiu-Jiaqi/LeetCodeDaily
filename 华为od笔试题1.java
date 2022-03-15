package LeetCodeDaily;

import java.util.Scanner;

/*
1. 翻转范围单词
    输入：三行，第一行输入一个字符串，单词用空格隔开，第二行为整数start，第三行为整数end
        整数出现负数输入则为第一个字符，超过字符串长度则为最后一个字符，不合法范围则直接输出原字符串
    输出：翻转start到end内的单词后输出
    思路：作些判断，然后直接双指针
*/
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] array = s.split(" ");
        int start = in.nextInt(), end = in.nextInt();
        if (start < 0) {
            start = 0;
        }
        if (end >= array.length) {
            end = array.length - 1;
        }
        if (end < 1 || start >= array.length) {
            System.out.println(s);
        } else {
            while (start < end) {
                String temp = array[start];
                array[start++] = array[end];
                array[end--] = temp;
            }
            System.out.println(String.join(" ", array));
        }
        in.close();
    }
}
