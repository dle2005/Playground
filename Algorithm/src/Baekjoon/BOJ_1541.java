package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sub = br.readLine().split("-");

        int sum = 0;

        for(int i = 0; i < sub.length; i++) {
            int subtraction = 0;
            if(sub[i].contains("+")) {
                String[] add = sub[i].split("\\+");

                for(String s : add)
                    subtraction += Integer.parseInt(s);
            }
            else
                subtraction = Integer.parseInt(sub[i]);

            if(i == 0)
                sum += subtraction;
            else
                sum -= subtraction;
        }

        System.out.println(sum);
    }
}
