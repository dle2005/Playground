package programmers;

public class P_12905 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
    }
    public static int solution(int [][]board)
    {
        int answer = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1 && i-1 >= 0 && j-1 >= 0)
                    board[i][j] = Math.min(board[i-1][j-1],
                            Math.min(board[i-1][j], board[i][j-1])) + 1;

                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer*answer;
    }
}

