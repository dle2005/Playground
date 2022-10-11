package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_60061 {
    public static void main(String[] args) {
        System.out.println(
                solution(5, new int[][]{{1,0,0,1},
                                            {1,1,1,1},
                                            {2,1,0,1},
                                            {2,2,1,1},
                                            {5,0,0,1},
                                            {5,1,0,1},
                                            {4,2,1,1},
                                            {3,2,1,1}}));
        System.out.println(
                solution(5, new int[][]{{0,0,0,1},
                                            {2,0,0,1},
                                            {4,0,0,1},
                                            {0,1,1,1},
                                            {1,1,1,1},
                                            {2,1,1,1},
                                            {3,1,1,1},
                                            {2,0,0,0},
                                            {1,1,1,0},
                                            {2,2,0,1}}));
    }
    public static class Build{
        int x;
        int y;
        int a;

        public Build(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;

            if(getClass() != obj.getClass()) return false;

            Build b = (Build) obj;

            if(x == b.x && y == b.y && a == b.a)
                return true;
            else return false;
        }
    }

    public static boolean[][] pillar, beam;

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        pillar = new boolean[n + 2][n + 2];
        beam = new boolean[n + 2][n + 2];

        List<Build> list = new ArrayList<>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0] + 1;
            int y = build_frame[i][1] + 1;

            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (b == 0) {
                if(a == 0) pillar[x][y] = false;
                else beam[x][y] = false;
                if(isDeletePromise(x, y, a, n)) {
                    list.remove(new Build(x - 1, y - 1, a));
                } else {
                    if (a == 0) pillar[x][y] = true;
                    else beam[x][y] = true;
                }
            } else if (b == 1) {
                if (a == 0 && buildPillar(x, y)) {
                    pillar[x][y] = true;
                    list.add(new Build(x - 1, y - 1, a));
                }
                else if (a == 1 && buildBeam(x, y)) {
                    beam[x][y] = true;
                    list.add(new Build(x - 1, y - 1, a));
                }
            }
        }

        answer = new int[list.size()][3];

        int index = 0;
        for(int i = 1 ; i <= n + 1 ; ++i){
            for(int j = 1 ; j <= n + 1 ; ++j){
                if(pillar[i][j]) answer[index++] = new int[]{i - 1, j - 1, 0};
                if(beam[i][j]) answer[index++] = new int[]{i - 1, j - 1, 1};
            }
        }

        return answer;
    }

    public static boolean buildPillar(int x, int y) {
        return y == 1 || pillar[x][y - 1] || beam[x][y] || beam[x - 1][y];
    }

    public static boolean buildBeam(int x, int y) {
        return pillar[x][y - 1] || pillar[x + 1][y - 1] || (beam[x - 1][y] && beam[x + 1][y]);
    }

    public static boolean isDeletePromise(int x, int y, int a, int n) {
        if(a == 0) pillar[x][y] = false;
        else beam[x][y] = false;

        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if(pillar[i][j] && !buildPillar(i, j)) {
                    return false;
                }
                if(beam[i][j] && !buildBeam(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
