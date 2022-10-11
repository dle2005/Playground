package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2661 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        backTracking("");
    }

    public static void backTracking(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int n = 1; n <= 3; n++) {
            String temp = str + n;

            if (isPromise(temp)) backTracking(temp);
        }
    }

    public static boolean isPromise(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String a = str.substring(str.length() - i - i, str.length() - i);
            String b = str.substring(str.length() - i);

            if(a.equals(b)) return false;
        }

        return true;
    }
}
