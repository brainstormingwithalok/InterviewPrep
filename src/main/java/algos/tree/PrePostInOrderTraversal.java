package main.java.algos.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PrePostInOrderTraversal {
    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.right.left=new Node(4);
//        System.out.println(inorder(root,new ArrayList<>()));
//        System.out.println(preOrder(root,new ArrayList<>()));
          System.out.println(postOrder(root,new ArrayList<>()));
//        System.out.println(preOrderUsingStack(root));
//        System.out.println(postOrderUsingStack(root));
    }

    public static List<Integer> inorder(Node root, List<Integer> result){
        if(root!=null) {
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
        return result;
    }

    public static List<Integer> preOrder(Node root, List<Integer> result){
        if(root!=null) {
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
        }
        return result;
    }

    public static List<Integer> postOrder(Node root, List<Integer> result){
        if(root!=null) {
            postOrder(root.left, result);
            postOrder(root.right, result);
            result.add(root.val);
        }
        return result;
    }

    public static List<Integer> preOrderUsingStack(Node root){
        List<Integer> result=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            Node node=stack.pop();
            result.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return result;
    }

    public static List<Integer> postOrderUsingStack(Node root){
        LinkedList<Integer> result=new LinkedList<>();
        Stack<Node> stack=new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            Node node=stack.pop();
            result.addFirst(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return result;
    }
}
