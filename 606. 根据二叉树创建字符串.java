package LeetCodeDaily;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
思路：递归，注意左子树为空，右子树不为空时
*/
class Solution {

    StringBuilder res;

    public String tree2str(TreeNode root) {
        res = new StringBuilder();
        helper(root);
        return res.toString().substring(1, res.length() - 1);
    }

    private void helper(TreeNode root) {
        if (root != null) {
            res.append("(" + root.val);
            if (root.left == null && root.right != null) {
                res.append("()");
            }
            helper(root.left);
            helper(root.right);
            res.append(")");
        }
    }
}