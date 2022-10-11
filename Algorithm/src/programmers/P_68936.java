package programmers;

public class P_68936 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]
                {       {1,1,1,1,1,1,1,1},
                        {0,1,1,1,1,1,1,1},
                        {0,0,0,0,1,1,1,1},
                        {0,1,0,0,1,1,1,1},
                        {0,0,0,0,0,0,1,1},
                        {0,0,0,0,0,0,0,1},
                        {0,0,0,0,1,0,0,1},
                        {0,0,0,0,1,1,1,1}
                }));
    }
    public static int ones, zeros;

    public static int[] solution(int[][] arr) {
        int[] answer = {};

        int n = arr.length;

        quarter(0, n, 0, n, arr);

        System.out.println(ones + " " + zeros);
        return answer = new int[]{zeros, ones};
    }

    public static void quarter(int i_start, int i_end, int j_start, int j_end, int[][] arr) {
        int first = arr[i_start][j_start];
        boolean flag = true;

        for (int i = i_start; i < i_end; i++) {
            for (int j = j_start; j < j_end; j++) {
                if (arr[i][j] != first) {

                    quarter(i_start, (i_start + i_end)/2, j_start, (j_start + j_end)/2, arr);
                    quarter(i_start, (i_start + i_end)/2, (j_start + j_end)/2, j_end, arr);
                    quarter((i_start + i_end)/2, i_end, j_start, (j_start + j_end)/2, arr);
                    quarter((i_start + i_end)/2, i_end, (j_start + j_end)/2, j_end, arr);

                    flag = false;
                    break;
                }
            }
            if(flag == false) break;
        }

        if (flag) {
            if(first == 1) ones++;
            else zeros++;
        }
    }
}
