package LeetCodeDaily;

import java.util.LinkedList;
import java.util.ListIterator;

class MyHashMap {
    private class Node {
        private final int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 733;
    private LinkedList<Node>[] data = new LinkedList[BASE];

    private int hash(int key) {
        return key % BASE;
    }

    public MyHashMap() {
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        ListIterator<Node> iterator = data[hash].listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                node.setValue(value);
                return;
            }
        }
        iterator.add(new Node(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        ListIterator<Node> iterator = data[hash].listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                return node.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        ListIterator<Node> iterator = data[hash].listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                iterator.remove();
                return;
            }
        }
    }
}
