package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<String> list = new LinkedList<>();

        while (N-- > 0) {
            String[] inputs = br.readLine().split(" ");

            if (inputs[0].equals("push")) {
                list.add(inputs[1]);
            } else if (inputs[0].equals("pop")) {
                if (list.isEmpty()) sb.append("-1").append("\n");
                else sb.append(list.remove(0)).append("\n");
            } else if (inputs[0].equals("size")) {
                sb.append(list.size()).append("\n");
            } else if (inputs[0].equals("empty")) {
                if (list.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (inputs[0].equals("front")) {
                if (list.isEmpty()) sb.append("-1").append("\n");
                else sb.append(list.get(0)).append("\n");
            } else if (inputs[0].equals("back")) {
                if (list.isEmpty()) sb.append("-1").append("\n");
                else sb.append(list.get(list.size() - 1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
