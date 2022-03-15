package LeetCodeDaily;

import java.util.*;

/*
3. 二叉树中序输出
    输入：一个字符串，由字母、'{'、'}'、','，组成，字母为节点值，{}内为前面字母子树，用','分割开
        若不存在右子树，则没有','，若不存在左子树则{}内先‘,’后接右子树
        保证输入合法
    输出：中序输出
    思路：先写了个二叉树，然后构建再输出
        使用stack：'{'入栈，'}'出栈，','记录右边，添加右子树后清除记录，字母时每次从stack中取出父节点添加孩子节点
*/
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(s.charAt(0));
        TreeNode cur = root;
        boolean right = false;
        char[] tree = s.toCharArray();
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == '{') {
                stack.push(cur);
            } else if (tree[i] == '}') {
                stack.pop();
            } else if (tree[i] == ',') {
                right = true;
            } else {
                cur = new TreeNode(tree[i]);
                TreeNode father = stack.peek();
                if (right) {
                    father.right = cur;
                    right = false;
                } else {
                    father.left = cur;
                }
            }
        }
        print(root);
        in.close();
    }

    public static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val);
            print(root.right);
        }
    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
