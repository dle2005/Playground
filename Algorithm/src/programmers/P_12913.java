package programmers;

public class P_12913 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5}, {5,6,7,8}, {4,3,2,1}}));
    }
    static int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }

        for(int i = 0; i < 4; i++)
            answer = Math.max(answer, land[land.length-1][i]);

        for(int[] i : land) {
            for(int j : i)
                System.out.print(j + " ");
            System.out.println();
        }

        return answer;
    }
}
