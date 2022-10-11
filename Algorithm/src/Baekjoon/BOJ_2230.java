package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;

        int low = 0, high = 0;
        while (high < N) {
            // 두 수의 차가 작은 경우 high를 이동시켜 더 큰 수 와 비교
            if(arr[high] - arr[low] < M) {
                high++;
            }
            // 두 수의 차가 M과 같은 경우 더 이상 탐색을 할 필요가 없음
            else if(arr[high] - arr[low] == M) {
                answer = M;
                break;
            }
            // 두 수의 차가 더 큰 경우 low를 이동시켜 더 작은 차 존재 확인
            else if(arr[high] - arr[low] > M) {
                answer = Math.min(answer, arr[high] - arr[low]);
                low++;
            }
        }

        System.out.println(answer);
    }
}
