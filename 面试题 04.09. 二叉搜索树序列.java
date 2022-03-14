package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
 * 思路：回溯法
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    List<TreeNode> select = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            res.add(new ArrayList<>());
            return res;
        }
        select.add(root);
        backTrack();
        return res;
    }

    private void backTrack() {
        if (select.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        List<TreeNode> cur_select = new ArrayList<>(select);
        for (TreeNode cur : cur_select) {
            path.add(cur.val);
            select.remove(cur);
            if (cur.left != null) {
                select.add(cur.left);
            }
            if (cur.right != null) {
                select.add(cur.right);
            }
            backTrack();
            path.remove(path.size() - 1);
            if (cur.left != null) {
                select.remove(select.size() - 1);
            }
            if (cur.right != null) {
                select.remove(select.size() - 1);
            }
            select.add(cur);
        }
    }
}