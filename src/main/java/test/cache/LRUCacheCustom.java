package test.cache;

import java.util.HashMap;
import java.util.Map;

class LRUCacheCustom {

    private final int maxSize;

    private Node head;

    private Node tail;

    private final Map<Integer, Node> cache;

    public LRUCacheCustom(int capacity) {
        this.maxSize = capacity;
        cache = new HashMap<>(capacity);
    }

    public synchronized int get(int key) {
        final Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToTail(node);
        return node.value;
    }

    public synchronized void put(int key, int value) {
        final Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToTail(node);
            return;
        }

        if (cache.size() == maxSize) {
            cache.remove(head.key);
            removeNode(head);
        }

        final Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addLastNode(newNode);
    }

    private void moveToTail(final Node node) {
        removeNode(node);
        addLastNode(node);
    }

    private void addLastNode(final Node node) {
        node.prevNode = tail;
        node.nextNode = null;

        if (tail != null) {
            tail.nextNode = node;
        }

        tail = node;

        if (head == null) {
            head = node;
        }
    }

    private void removeNode(final Node node) {
        final Node prevNode = node.prevNode;
        final Node nextNode = node.nextNode;

        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.nextNode = nextNode;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prevNode = prevNode;
        }
    }

    private static class Node {

        private final int key;
        private int value;
        private Node prevNode;
        private Node nextNode;

        Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

    }

}