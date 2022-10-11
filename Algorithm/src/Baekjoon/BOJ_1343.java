package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        while (s.contains("XXXX"))
            s = s.replaceAll("XXXX", "AAAA");

        while (s.contains("XX"))
            s = s.replace("XX", "BB");

        System.out.println(s.contains("X") ? -1 : s);
    }
}
