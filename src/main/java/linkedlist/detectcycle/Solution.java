package linkedlist.detectcycle;

import java.util.HashSet;
import java.util.Set;

class Solution {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    boolean hasCycle(Node head) {
        Set<Node> visitedNodes = new HashSet<>();

        for (Node node = head; node != null; node = node.next) {
            final boolean added = visitedNodes.add(node);
            if (!added) {
                return true;
            }
        }

        return false;
    }

}
