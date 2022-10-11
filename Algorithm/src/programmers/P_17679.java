package programmers;

import java.util.Arrays;

public class P_17679 {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        for(int i = 0; i < board.length; i++)
            map[i] = board[i].toCharArray();

        while (true) {
            int cnt = delete(m, n, map);
            if(cnt == 0) break;
            answer += cnt;
        }

        return answer;
    }

    public static int delete(int m, int n, char[][] map) {
        int cnt = 0;
        char[][] temp = new char[m][n];
        for (int i = 0; i < m; i++) temp[i] = Arrays.copyOf(map[i], map[i].length);

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = map[i][j];
                if(c == 0) continue;

                if (map[i][j + 1] == c && map[i + 1][j] == c && map[i + 1][j + 1] == c) {
                    if(temp[i][j] != '0') cnt++; temp[i][j] = '0';
                    if(temp[i][j+1] != '0') cnt++; temp[i][j+1] = '0';
                    if(temp[i+1][j] != '0') cnt++; temp[i+1][j] = '0';
                    if(temp[i+1][j+1] != '0') cnt++; temp[i+1][j+1] = '0';
                }
            }
        }

        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                if (temp[i][j] != '0') sb.append(temp[i][j]);
            }

            for (int i = 0; i < sb.length(); i++)
                map[m-i-1][j] = sb.charAt(sb.length()-i-1);
            for(int i = 0; i < m - sb.length(); i++)
                map[i][j] = '0';
        }

        return cnt;
    }
}
