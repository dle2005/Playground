package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    public static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }
    }

    public static class Tree {
        Node root;

        public void makeTree(int num) {
            if (root == null) root = new Node(num);
            else search(root, num);
        }

        public void search(Node parent, int num) {
            if (parent.num > num) {
                if(parent.left == null) parent.left = new Node(num);
                else search(parent.left, num);
            } else {
                if(parent.right == null) parent.right = new Node(num);
                else search(parent.right, num);
            }
        }

        public void postOrder(Node node) {
            if(node != null) {
                postOrder(node.left);
                postOrder(node.right);
                sb.append(node.num).append("\n");
            }
        }
    }

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree tree = new Tree();

        while (true) {
            String n = br.readLine();
            if(n == null || n.length() == 0) break;

            tree.makeTree(Integer.parseInt(n));
        }

        tree.postOrder(tree.root);

        System.out.println(sb);
    }
}
