package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;

/*
思路：逆向思维，不解密，加密字典来记录次数
*/
class Encrypter {
    String[] map = new String[26];
    Map<String, Integer> cnt = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            map[keys[i] - 'a'] = values[i];
        }
        for (String dic : dictionary) {
            String edic = encrypt(dic);
            cnt.put(edic, cnt.getOrDefault(edic, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        for (char ch : word1.toCharArray()) {
            res.append(map[ch - 'a']);
        }
        return res.toString();
    }

    public int decrypt(String word2) {
        return cnt.getOrDefault(word2, 0);
    }
}
