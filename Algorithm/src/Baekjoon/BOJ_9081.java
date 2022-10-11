package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String s = br.readLine();
            char[] arr = new char[s.length()];

            for(int j = 0; j < s.length(); j++)
                arr[j] = s.charAt(j);

            int a = 0, b = 0; boolean flag = false;
            int min = Integer.MAX_VALUE;
            for(int j = s.length()-1; j >= 0; j--) {
                for(int k = j; k < s.length(); k++) {
                    if(arr[j] < arr[k]) {
                        if(min > arr[k]) {
                            min = arr[k];
                            a = j;
                            b = k;

                            flag = true;
                        }
                    }
                }

                if(flag)
                    break;
            }

            char temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;


            if(flag)
                Arrays.sort(arr, a+1, s.length());

            for(char j : arr)
                System.out.print(j);
            System.out.println();
        }
    }
}
