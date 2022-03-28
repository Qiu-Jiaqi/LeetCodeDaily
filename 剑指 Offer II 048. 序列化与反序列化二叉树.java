package LeetCodeDaily;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
 * 思路：层序遍历
 */
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                res.append('#');
            } else {
                res.append(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            res.append(',');
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if ("#".equals(nodes[0])) {
            return null;
        }
        TreeNode res = new TreeNode(Integer.valueOf(nodes[0]));
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(res);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = q.peek();
            if ((i & 1) == 1) {
                if (!"#".equals(nodes[i])) {
                    cur.left = new TreeNode(Integer.valueOf(nodes[i]));
                    q.offer(cur.left);
                }
            } else {
                if (!"#".equals(nodes[i])) {
                    cur.right = new TreeNode(Integer.valueOf(nodes[i]));
                    q.offer(cur.right);
                }
                q.poll();
            }
        }
        return res;
    }
}
