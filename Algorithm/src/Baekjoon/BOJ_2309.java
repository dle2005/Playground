package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        loop :
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j != i && j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = arr[j] = 0;
                    break loop;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if(num != 0) list.add(num);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int num : list)
            sb.append(num).append("\n");

        System.out.println(sb);
    }
}
