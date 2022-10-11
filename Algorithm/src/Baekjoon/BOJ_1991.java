package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1991 {
    public static class Node {
        char name;
        Node leftChild;
        Node rightChild;

        public Node() { }

        public Node(char name) {
            this.name = name;
        }
    }

    public static class Tree {
        Node root;

        public void inOrder(Node root) {
            if (root != null) {
                inOrder(root.leftChild);
                in_order.add(root.name);
                inOrder(root.rightChild);
            }
        }

        public void postOrder(Node root) {
            if (root != null) {
                postOrder(root.leftChild);
                postOrder(root.rightChild);
                post_order.add(root.name);
            }
        }

        public void preOrder(Node root) {
            if(root != null) {
                pre_order.add(root.name);
                preOrder(root.leftChild);
                preOrder(root.rightChild);
            }
        }

        public void makeTree(char V, char L, char R) {
            if (root == null) {
                root = new Node(V);

                if (L != '.') root.leftChild = new Node(L);
                if (R != '.') root.rightChild = new Node(R);
            } else {
                makeChild(root, V, L, R);
            }
        }

        public void makeChild(Node root, char V, char L, char R) {
            if(root == null) return;

            if (root.name == V) {
                if (L != '.') root.leftChild = new Node(L);
                if (R != '.') root.rightChild = new Node(R);
            } else {
                makeChild(root.leftChild, V, L, R);
                makeChild(root.rightChild, V, L, R);
            }
        }
    }

    public static List<Character> pre_order = new ArrayList<>();
    public static List<Character> post_order = new ArrayList<>();
    public static List<Character> in_order = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char V = st.nextToken().charAt(0);
            char L = st.nextToken().charAt(0);
            char R = st.nextToken().charAt(0);

            tree.makeTree(V, L, R);
        }

        tree.preOrder(tree.root);
        tree.inOrder(tree.root);
        tree.postOrder(tree.root);

        for(char c : pre_order)
            sb.append(c);
        sb.append("\n");

        for(char c : in_order)
            sb.append(c);
        sb.append("\n");

        for(char c : post_order)
            sb.append(c);
        sb.append("\n");

        System.out.println(sb);
    }
}
