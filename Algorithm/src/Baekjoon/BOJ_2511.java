package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArrA = br.readLine().split(" ");
        String[] strArrB = br.readLine().split(" ");

        int scoreA = 0, scoreB = 0;
        String lastWinner = "D";

        for (int i = 0; i < 10; i++) {
            if (strArrA[i].compareTo(strArrB[i]) == 0) {
                scoreA++;
                scoreB++;
            } else if (strArrA[i].compareTo(strArrB[i]) > 0) {
                scoreA += 3;
                lastWinner = "A";
            } else {
                scoreB += 3;
                lastWinner = "B";
            }
        }

        System.out.println(scoreA + " " + scoreB);
        System.out.println(
                lastWinner.equals("D") ? "D"
                        : scoreA == scoreB ? lastWinner
                        : scoreA > scoreB ? "A"
                        : "B"
        );
    }
}
