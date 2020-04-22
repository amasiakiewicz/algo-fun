package tree.lowestcommanc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    public static Node lca(Node root, int v1, int v2) {
        
        final List<Node> pathV1 = getPath(root, v1);
        final List<Node> pathV2 = getPath(root, v2);
        
        pathV1.retainAll(pathV2);
        
        return pathV1.get(0);
    }

    private static List<Node> getPath(Node root, int v) {
        if (root.data == v) {
            final ArrayList<Node> path = new ArrayList<>();
            path.add(root);
            
            return path;
        }

        List<Node> path = null;
        if (root.left != null) {
            path = getPath(root.left, v);
        }

        if (path == null && root.right != null) {
            path = getPath(root.right, v);
        }
        if (path != null) {
            path.add(root);
        }
        
        return path;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}