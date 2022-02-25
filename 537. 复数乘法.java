package LeetCodeDaily;

/*
注意：+需要转义，然后多个分隔符用|隔开
*/
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] n1 = num1.split("\\+|i"), n2 = num2.split("\\+|i");
        int real = Integer.valueOf(n1[0]) * Integer.valueOf(n2[0]) - Integer.valueOf(n1[1]) * Integer.valueOf(n2[1]);
        int virtual = Integer.valueOf(n1[0]) * Integer.valueOf(n2[1]) + Integer.valueOf(n1[1]) * Integer.valueOf(n2[0]);
        return real + "+" + virtual + "i";
    }
}