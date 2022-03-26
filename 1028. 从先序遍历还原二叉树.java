package LeetCodeDaily;

import java.util.Deque;
import java.util.LinkedList;

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
 * 思路：用栈
 * 每次遇到数字先算出val，创建当前节点cur，然后判断stack是否为空，再判断栈顶元素左孩子是否为空，为空则为栈顶左孩子，否则为右孩子
 * 然后把当前节点cur加入栈，再计算下一个的深度，多少个'-'即多深，也表示当前栈应该存储的节点数，把多余的栈元素出栈
 * 最后返回栈底元素即为根节点
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int index = 0; index < traversal.length();) {
            int val = 0;
            while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
                val = val * 10 + traversal.charAt(index++) - '0';
            }
            TreeNode cur = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = cur;
                } else {
                    stack.peek().right = cur;
                }
            }
            stack.push(cur);
            if (index == traversal.length()) {
                break;
            }
            int depth = 0;
            while (traversal.charAt(index) == '-') {
                depth++;
                index++;
            }
            while (stack.size() > depth) {
                stack.poll();
            }
        }
        return stack.peekLast();
    }
}
