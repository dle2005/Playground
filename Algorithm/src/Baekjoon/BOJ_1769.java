package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1769 {
    public static int cnt = 0;
    public static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();

        change(X);

        System.out.println(cnt);
        System.out.println(flag ? "YES" : "NO");
    }

    public static void change(String X) {
        int sum = 0;

        if(X.length() > 1) {
            for (int i = 0; i < X.length(); i++)
                sum += Integer.parseInt(String.valueOf(X.charAt(i)));
            cnt++;
            change(String.valueOf(sum));
        }
        else {
            if (Integer.parseInt(X) % 3 == 0) flag = true;
            else flag = false;
        }
    }
}
