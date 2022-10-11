package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_16922 {
    public static int N, answer;
    public static int[] nums = {1, 5, 10, 50};
    public static boolean[] visit = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        permutation(0, 0, 0);

        System.out.println(answer);
    }

    public static void permutation(int depth, int idx, int sum) {
        if (depth == N) {
            if (!visit[sum]) {
                visit[sum] = true;
                answer++;
            }

            return;
        }

        for (int i = idx; i < 4; i++) {
            permutation(depth + 1, i, sum + nums[i]);
        }
    }
}
