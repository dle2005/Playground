package programmers;

public class P_1832 {
    public static void main(String[] args) {
//        System.out.println(solution(3, 3, new int[][]{
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
//        }));
        System.out.println(solution(3, 6, new int[][]{
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}
        }));
    }
    public static final int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][][] dp = new int[m + 1][n + 1][2];
        dp[1][1][0] = dp[1][1][1] = 1;
        // 0 오른쪽, 1 아래쪽

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i-1][j-1] == 0) {
                    dp[i][j][0] += (dp[i][j - 1][0] + dp[i - 1][j][1]) % MOD;
                    dp[i][j][1] += (dp[i][j - 1][0] + dp[i - 1][j][1]) % MOD;
                } else if (cityMap[i-1][j-1] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][0] = dp[i][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1];
                }
            }
        }

        return answer = dp[m][n][0];
    }
}
