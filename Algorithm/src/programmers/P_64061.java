package programmers;

import java.util.Stack;

public class P_64061 {
    public static void main(String[] args) {
        // 게임 화면은 N x N 크기의 정사각 격자
        // 위쪽에는 크레인이 있고 오른쪽에는 바구니
        // 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올림
        // 집어 올린 인형은 바구니에 쌓이게 되는데, 가장 아래 칸부터 순서대로 쌓인다

        // 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 바구니에서 사라짐

        // 사라진 인형의 갯수를 출력!!!

        solution(new int[][]{{0,0,0,0,0},
                            {0,0,1,0,3},
                            {0,2,5,0,1},
                            {4,2,4,4,2},
                            {3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4});
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++) {
            // 크래인이 어디를 가르칠지
            int j_index = moves[i] - 1;

            // 아래로 탐색하여 인형을 집어 올림
            for(int j = 0; j < board.length; j++) {
                if(board[j][j_index] != 0) {
                    int doll = board[j][j_index];

                    // 스택의 최상단에 인형이랑 같은 것이 존재하면 제거
                    if(!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    }
                    else stack.push(doll); // 다를시 추가

                    // 인형이 사라졌음으로 0으로 변경
                    board[j][j_index] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
