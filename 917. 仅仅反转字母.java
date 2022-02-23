package LeetCodeDaily;

/*
思路：简单的双指针，就是要记得里面的while循环写left < right，等于时候退出循环

两年前的错，如今又犯，代码逻辑也竟一模一样，就是当初是用了toCharArray()转换，然后new String返回
*/
class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder res = new StringBuilder(s);
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            while (left < right && !Character.isLetter(res.charAt(left)))
                left++;
            while (left < right && !Character.isLetter(res.charAt(right)))
                right--;
            if (left == right) {
                break;
            }
            char temp = res.charAt(left);
            res.setCharAt(left, res.charAt(right));
            res.setCharAt(right, temp);
        }
        return res.toString();
    }
}