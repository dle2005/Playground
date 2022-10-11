package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_42892 {
    public static void main(String[] args) {
        int[][] test = solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});

        for(int i : test[0])
            System.out.print(i + " ");
        System.out.println();
        for(int i : test[1])
            System.out.print(i + " ");
    }

    public static class Node implements Comparable<Node> {
        int num;
        int x;
        int y;
        Node leftChild;
        Node rightChild;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return o.y - this.y;
        }
    }

    public static List<Node> list = new ArrayList<>();
    public static List<Integer> pre_order = new ArrayList<>();
    public static List<Integer> post_order = new ArrayList<>();

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        for (int i = 0; i < nodeinfo.length; i++)
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));

        Collections.sort(list);

        Node root = list.get(0);
        for (int i = 1; i < list.size(); i++)
            makeTree(root, list.get(i));

        preOrder(root);
        postOrder(root);

        answer = new int[2][list.size()];

        answer[0] = pre_order.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post_order.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void postOrder(Node parent) {
        if (parent != null) {
            postOrder(parent.leftChild);
            postOrder(parent.rightChild);
            post_order.add(parent.num);
        }
    }

    public static void preOrder(Node parent) {
        if (parent != null) {
            pre_order.add(parent.num);
            preOrder(parent.leftChild);
            preOrder(parent.rightChild);
        }
    }

    public static void makeTree(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.leftChild == null)
                parent.leftChild = child;
            else makeTree(parent.leftChild, child);
        } else {
            if (parent.rightChild == null)
                parent.rightChild = child;
            else makeTree(parent.rightChild, child);
        }
    }
}
