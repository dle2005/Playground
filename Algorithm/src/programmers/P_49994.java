package programmers;

public class P_49994 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
    public static class Pos {
        public int i;
        public int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int solution(String dirs) {
        int answer = 0;

        boolean[][][] visit = new boolean[11][11][4];
        Pos pos = new Pos(5, 5);

        for(int i = 0; i < dirs.length(); i++) {
            char move = dirs.charAt(i);

            if(move == 'U' && pos.i - 1 >= 0) {
                pos.i -= 1;
                if(!visit[pos.i][pos.j][0]) {
                    answer++;
                    visit[pos.i][pos.j][0] = true;
                    visit[pos.i+1][pos.j][1] = true;
                }
            }
            else if(move == 'D' && pos.i + 1 < 11) {
                pos.i += 1;
                if(!visit[pos.i][pos.j][1]) {
                    answer++;
                    visit[pos.i][pos.j][1] = true;
                    visit[pos.i-1][pos.j][0] = true;
                }
            }
            else if(move == 'R' && pos.j + 1 < 11) {
                pos.j += 1;
                if(!visit[pos.i][pos.j][2]) {
                    answer++;
                    visit[pos.i][pos.j][2] = true;
                    visit[pos.i][pos.j-1][3] = true;
                }
            }
            else if(move == 'L' && pos.j - 1 >= 0) {
                pos.j -= 1;
                if(!visit[pos.i][pos.j][3]) {
                    answer++;
                    visit[pos.i][pos.j][3] = true;
                    visit[pos.i][pos.j+1][2] = true;
                }
            }
        }


        return answer;
    }
}
