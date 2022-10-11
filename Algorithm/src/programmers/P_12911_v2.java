package programmers;

public class P_12911_v2 {
    public static void main(String[] args) {

    }
    public static int solution(int n) {
        int answer = 0;

        int cnt = Integer.bitCount(n);

        for (int i = n + 1; i <= 1_000_000; i++){
            if (Integer.bitCount(i) == cnt) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
