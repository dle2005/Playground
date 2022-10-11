package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
    public static long X, Y, Z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Z = Y * 100 / X;
        if(Z >= 99) {
            System.out.println(-1);
            return;
        }

        long answer = Integer.MAX_VALUE;
        long low = 1, high = 1000000001;
        while (low <= high) {
            long mid = (low + high) / 2;

            if (bSearch(mid)) {
                answer = Math.min(answer, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static boolean bSearch(long t) {
        long xt = X + t, yt = Y + t;
        long new_Z = (yt * 100) / xt;

        if (new_Z > Z) return true;
        else return false;
    }
}
