package programmers;

public class P_12985 {
    public static void main(String[] args) {

    }
    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (true) {
            if (a == b) break;

            a = (a + 1) / 2;
            b = (b + 1) / 2;

            answer++;
        }

        return answer;
    }
}
