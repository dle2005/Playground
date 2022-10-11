package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9328 {
    public static int h, w;
    public static char[][] map;
    public static boolean[][] visit;
    public static List<Door>[] list;
    public static boolean[] alp;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            list = new List[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }

            map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= h; i++) {
                String t = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = t.charAt(j - 1);
                }
            }

            alp = new boolean[26];
            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    alp[keys.charAt(i) - 'a'] = true;
                }
            }

            bfs();
        }
    }

    public static void bfs() {
        int cnt = 0;

        Queue<Door> queue = new LinkedList<>();
        queue.add(new Door(0, 0));

        visit = new boolean[h + 2][w + 2];
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Door cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
                if (map[nx][ny] == '*' || visit[nx][ny]) continue;

                if (Character.isUpperCase(map[nx][ny])) { // 문을 방문한 경우
                    if (alp[map[nx][ny] - 'A']) { // 열쇠를 가지고 있는 경우
                        map[nx][ny] = '.';
                        visit[nx][ny] = true;
                        queue.add(new Door(nx, ny));
                    } else {
                        // 나중에 열쇠를 찾고 방문할 수 있도록 저장
                        list[map[nx][ny] - 'A'].add(new Door(nx, ny));
                    }
                } else if (Character.isLowerCase(map[nx][ny])) { // 열쇠를 찾은 경우
                    alp[map[nx][ny] - 'a'] = true;
                    visit[nx][ny] = true;
                    queue.add(new Door(nx, ny));

                    for (Door d : list[map[nx][ny] - 'a']) {
                        map[d.x][d.y] = '.';
                        visit[d.x][d.y] = true;
                        queue.add(new Door(d.x, d.y));
                    }
                    list[map[nx][ny] - 'a'] = new ArrayList<>();
                } else if (map[nx][ny] == '$') {
                    cnt++;
                    visit[nx][ny] = true;
                    queue.add(new Door(nx, ny));
                } else {
                    visit[nx][ny] = true;
                    queue.add(new Door(nx, ny));
                }
            }
        }

        System.out.println(cnt);
    }

    public static class Door {
        int x, y;

        public Door(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
