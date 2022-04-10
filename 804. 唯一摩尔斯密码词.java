package LeetCodeDaily;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] map = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.setLength(0);
            for (char ch : word.toCharArray()) {
                sb.append(map[ch - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
