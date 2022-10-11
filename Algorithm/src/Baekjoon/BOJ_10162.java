package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int btnTimeA = 300, btnTimeB = 60, btnTimeC = 10;
        int cntBtnA = 0, cntBtnB = 0, cntBtnC = 0;
        int T = Integer.parseInt(br.readLine());

        if (T % btnTimeC != 0) {
            System.out.println(-1);

            return;
        }

        if (T >= btnTimeA) {
            cntBtnA += T / btnTimeA;
            T %= btnTimeA;
        }

        if (T >= btnTimeB) {
            cntBtnB += T / btnTimeB;
            T %= btnTimeB;
        }

        cntBtnC += T / btnTimeC;
        T %= btnTimeC;

        System.out.println(cntBtnA + " " + cntBtnB + " " + cntBtnC);
    }
}
