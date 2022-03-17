package LeetCodeDaily;

/*
思路：
    1. 排序后用哈希表：排序时，先按长度升序，后按字典降序
    2. 字典树
*/

/* class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.length() != b.length() ? a.length() - b.length() : b.compareTo(a);
        });
        String res = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                res = word;
            }
        }
        return res;
    }
} */

class Solution {
    public String longestWord(String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            trie.insert(word);
        }
        String res = "";
        for (String word : words) {
            // 长度比已有答案短，就不必去查找判断了
            if (word.length() < res.length() || !trie.search(word)) {
                continue;
            } else if (word.length() > res.length() || word.compareTo(res) < 0) {
                res = word;
            }
        }
        return res;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public void setWord() {
        isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public void insert(String word) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.setWord();
    }

    public boolean search(String word) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null || !cur.isWord()) {
                return false;
            }
        }
        return true;
    }
}