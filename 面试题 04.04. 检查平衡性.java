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
思路：判断左右子树高度差<=1，且左右子树也平衡
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return root == null ? true : Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
