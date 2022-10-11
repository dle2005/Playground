package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        for (int i = 1; i < input.length; i++) {
            sb.append(input[0]);
            StringBuilder var = new StringBuilder();

            for (int j = input[i].length() - 2; j >= 0; j--) {
                if (Character.isAlphabetic(input[i].charAt(j))) {
                    var.insert(0, input[i].charAt(j));
                } else if (input[i].charAt(j) == ']') {
                    sb.append("[]");
                    j--;
                } else sb.append(input[i].charAt(j));
            }

            sb.append(" ")
                    .append(var)
                    .append(";\n");
        }

        System.out.println(sb);
    }
}
