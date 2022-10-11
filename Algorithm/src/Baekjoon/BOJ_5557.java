package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.parseInt(st.nextToken());

        long[] cnt = new long[21];
        cnt[nums[0]]++;

        for (int i = 1; i < N - 1; i++) {
            long[] temp = new long[21];

            for (int j = 0; j <= 20; j++) {
                if (cnt[j] != 0) {
                    if (j + nums[i] <= 20) {
                        temp[j + nums[i]] += cnt[j];
                    }

                    if (j - nums[i] >= 0) {
                        temp[j - nums[i]] += cnt[j];
                    }
                }
            }

            cnt = temp;
        }

        System.out.println(cnt[result]);
    }
}
