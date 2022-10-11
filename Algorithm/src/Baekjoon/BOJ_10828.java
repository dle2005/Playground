package Baekjoon;

import java.util.Scanner;

public class BOJ_10828 {

    public static int[] stack;
    public static int top = -1;

    public static int empty() {
        if(top == -1) return 1;
        else return 0;
    }

    public static int top() {
        if(empty() == 1) return -1;
        return stack[top];
    }

    public static void push(int x) {
        stack[++top] = x;
    }

    public static int pop() {
        if(empty() == 1) return -1;
        int temp = stack[top--];
        return temp;
    }

    public static int size() {
        return top+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int N = sc.nextInt();
        stack = new int[N];

        for(int i = 0; i < N; i++) {
            String str = sc.next();

            switch (str) {
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb);

        sc.close();
    }
}
