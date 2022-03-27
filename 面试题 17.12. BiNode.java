package LeetCodeDaily;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
 * 思路：倒置中序遍历处理
 */
class Solution {
    TreeNode pre = null;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBiNode(root.right);
        root.right = pre;
        pre = root;
        convertBiNode(root.left);
        root.left = null;
        return pre;
    }
}