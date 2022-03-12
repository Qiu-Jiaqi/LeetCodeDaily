package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    private List<Integer> res;

    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        post(root);
        return res;
    }

    private void post(Node root) {
        if (root != null) {
            for (Node child : root.children) {
                post(child);
            }
            res.add(root.val);
        }
    }
}
