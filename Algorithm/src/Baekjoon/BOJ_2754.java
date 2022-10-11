package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] grade = br.readLine().toCharArray();

        double answer = 0.0;

        if(grade[0] == 'A') answer = 4.0;
        else if(grade[0] == 'B') answer = 3.0;
        else if(grade[0] == 'C') answer = 2.0;
        else if(grade[0] == 'D') answer = 1.0;
        else {
            System.out.println(0.0);
            return;
        }

        if(grade[1] == '+') answer += 0.3;
        else if(grade[1] == '-') answer -= 0.3;

        System.out.println(answer);
    }
}
