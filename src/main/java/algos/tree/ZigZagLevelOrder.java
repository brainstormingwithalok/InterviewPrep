package main.java.algos.tree;

import java.util.*;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(9);
        root.right=new Node(20);
        root.right.left=new Node(15);
        root.right.right=new Node(7);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<Node> stack = new LinkedList<>();
        if (root == null) {
            return results;
        }
        stack.add(root);
        boolean reverse = false;
        while (!stack.isEmpty()) {
            int size = stack.size();
            LinkedList<Integer> result = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = stack.remove();
                result.add(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            if (reverse) {
                Collections.reverse(result);
                results.add(result);
            } else {
                results.add(result);
            }
            reverse = !reverse;
        }
        return results;
    }
}
