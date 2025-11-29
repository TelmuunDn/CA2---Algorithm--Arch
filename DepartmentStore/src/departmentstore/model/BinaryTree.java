/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentstore.model;

/**
 *
 * @author telmuun
 */


import java.util.*;

public class BinaryTree {

    public static class Node {
        public Employee data;
        public Node left, right;

        public Node(Employee data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(Employee emp) {
        Node newNode = new Node(emp);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.left == null) {
                curr.left = newNode;
                return;
            } else queue.add(curr.left);

            if (curr.right == null) {
                curr.right = newNode;
                return;
            } else queue.add(curr.right);
        }
    }

    public void displayLevelOrder() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.println(n.data);

            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    public int height(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    public int getHeight() {
        return height(root);
    }

    public int getNodeCount() {
        return count(root);
    }

    private int count(Node n) {
        if (n == null) return 0;
        return 1 + count(n.left) + count(n.right);
    }
}

