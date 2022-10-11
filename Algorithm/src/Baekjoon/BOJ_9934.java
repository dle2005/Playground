package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934 {
    public static List<Integer> arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        arr = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Math.pow(2, K) - 1; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= K; i++) {
            seek((int) Math.pow(2, (K - i + 1)) - 1, 0, (int) Math.pow(2, (i - 1)), (int) (Math.pow(2, (K - i)) - 1));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void seek(int depth, int cnt, int max, int index) {
        if (cnt == max) return;

        sb.append(arr.remove(index)).append(" ");

        if (arr.size() == 0) return;
        seek(depth, cnt + 1, max, (index + depth - 1) % arr.size());
    }
}
