package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1759 {
    public static StringBuilder sb = new StringBuilder();
    public static int L, C;
    public static char[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visit = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++)
            arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);

        password("", 0, 0, false, 0);

        System.out.println(sb);
    }

    public static void password(String s, int depth, int start, boolean mo, int ja) {
        if(depth == L) {
            if(mo && ja >= 2) sb.append(s).append("\n");
            return;
        }

        for(int i = start; i < C; i++) {
            if(!visit[i]) {
                visit[i] = true;
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
                    password(s + arr[i], depth + 1, i, true, ja);
                else
                    password(s + arr[i], depth + 1, i, mo, ja+1);
                visit[i] = false;
            }
        }
    }
}
