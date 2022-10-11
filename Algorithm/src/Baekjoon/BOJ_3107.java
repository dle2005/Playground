package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = new char[32];
        Arrays.fill(arr, '0');

        boolean flag = false;

        String[] s = br.readLine().split(":");
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("")) {
                flag = true;
                break;
            }

            for (int j = 0; j < s[i].length(); j++)
                arr[i * 4 + 3 - j] = s[i].charAt(s[i].length() - 1 - j);
        }

        if (flag) {
            int index = 7;
            for (int i = s.length - 1; i >= 0; i--) {
                if (s[i].equals("")) break;

                for (int j = 0; j < s[i].length(); j++)
                    arr[index * 4 + 3 - j] = s[i].charAt(s[i].length() - 1 - j);

                index--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (i != 0 && i % 4 == 0) sb.append(":");

            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}
