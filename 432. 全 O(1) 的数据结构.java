package LeetCodeDaily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
思路：哈希表+双向链表
    看官方题解的，然后把判断插入的逻辑放到了双向链表里面
    插入时：根据count值来判断是插入前面还是后面，再判断是否需要新建节点
    增加时：获取当前key的Node，若不存在则获取root，然后插入count+1。若当前Node不为root（即原来存在），则从原Node的set中删去key
    减少时：获取当前key的Node（题目说必存在），若count值为1，则从map中删去key，否则插入count-1，然后从原Node中的set中删去key
*/
class Node {
    int count;
    Set<String> keys;
    Node prev;
    Node next;

    public Node() {
        this("", 0);
        this.prev = this;
        this.next = this;
    }

    public Node(String key, int count) {
        this.count = count;
        keys = new HashSet<>();
        keys.add(key);
    }

    public Node insert(String key, int count) {
        if (count > this.count) {
            return this.insertNext(key, count);
        } else {
            return this.insertPrev(key, count);
        }
    }

    private Node insertNext(String key, int count) {
        // 若存在了count的节点，直接在set中加入key
        if (this.next.count == count) {
            this.next.keys.add(key);
            return this.next;
        } else {
            // 否则新建节点插入后面
            Node node = new Node(key, count);
            node.prev = this;
            node.next = this.next;
            node.prev.next = node;
            node.next.prev = node;
            return node;
        }
    }

    private Node insertPrev(String key, int count) {
        // 若存在了count的节点，直接在set中加入key
        if (this.prev.count == count) {
            this.prev.keys.add(key);
            return this.prev;
        } else {
            // 否则新建节点插入前面
            Node node = new Node(key, count);
            node.prev = this.prev;
            node.next = this;
            node.prev.next = node;
            node.next.prev = node;
            return node;
        }
    }

    public void removeKey(String key) {
        this.keys.remove(key);
        // 当keys为空，直接删去链表节点
        if (this.keys.isEmpty()) {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }
}

class AllOne {

    private Node root;
    private Map<String, Node> nodes;

    public AllOne() {
        root = new Node();
        nodes = new HashMap<>();
    }

    public void inc(String key) {
        Node cur = nodes.getOrDefault(key, root);
        nodes.put(key, cur.insert(key, cur.count + 1));
        if (cur != root) {
            cur.removeKey(key);
        }
    }

    public void dec(String key) {
        Node cur = nodes.get(key);
        if (cur.count == 1) {
            nodes.remove(key);
        } else {
            nodes.put(key, cur.insert(key, cur.count - 1));
        }
        cur.removeKey(key);
    }

    public String getMaxKey() {
        return root.prev != root ? root.prev.keys.iterator().next() : "";
    }

    public String getMinKey() {
        return root.next != root ? root.next.keys.iterator().next() : "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */