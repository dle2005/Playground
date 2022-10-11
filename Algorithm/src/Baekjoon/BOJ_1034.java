package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] ss = new String[N];
        int[][] compare = new int[N][2];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            ss[i] = s;
            for(int j = 0; j < M; j++) {
                if(s.charAt(j)-'0' == 0)
                    compare[i][1]++;
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(ss[i].equals(ss[j]))
                    compare[i][0]++;
            }
        }

        Arrays.sort(compare, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int i = 0; i < N; i++) {
            if(compare[i][1] == K) {
                System.out.println(compare[i][0]);
                return;
            } else if (compare[i][1] < K) {
                if((K - compare[i][1]) % 2 == 0) {
                    System.out.println(compare[i][0]);
                    return;
                }

            }
        }

        System.out.println(0);
    }
}
