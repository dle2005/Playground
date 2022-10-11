package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

public class BOJ_2596 {
    public static final Map<String, String> alpMap = Map.of(
            "000000", "A",
            "001111", "B",
            "010011", "C",
            "011100", "D",
            "100110", "E",
            "101001", "F",
            "110101", "G",
            "111010", "H"
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder answer = new StringBuilder();

        loop:
        for (int i = 0; i < N; i++) {
            String subStr = str.substring(i * 6, (i + 1) * 6);

            for (Entry<String, String> map : alpMap.entrySet()) {
                if (map.getKey().equals(subStr) || check(subStr, map.getKey())) {
                    answer.append(map.getValue());

                    continue loop;
                }
            }

            System.out.println(i + 1);

            return;
        }

        System.out.println(answer);
    }

    public static boolean check(String subStr, String alpKey) {
        int cnt = 0;

        for (int i = 0; i < 6; i++) {
            if (subStr.charAt(i) != alpKey.charAt(i)) {
                cnt++;

                if (cnt >= 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
