package Jungol;

public class J_556 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 1; i <= 10; i++)
            arr[i - 1] = i;

        StringBuilder sb = new StringBuilder();
        for (int n : arr) sb.append(n).append(" ");

        System.out.println(sb);
    }
}
