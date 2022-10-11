package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_12052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == '#') cnt++;
                }
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < M - 1; j++) {
                    if (map[i][j] == '#' && map[i + 1][j] == '#' && map[i][j + 1] == '#' && map[i + 1][j + 1] == '#') {
                        map[i][j] = map[i + 1][j] = map[i][j + 1] = map[i + 1][j + 1] = ',';
                        cnt -= 4;
                    }
                }
            }

            if (cnt == 0) sb.append("#" + index + " " + "YES" + "\n");
            else sb.append("#" + index + " " + "NO" + "\n");
        }

        System.out.println(sb);
    }
}
