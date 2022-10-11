package programmers;

public class P_12911 {
    public static void main(String[] args) {
        solution(78);
    }
    public static int solution(int n) {
        int answer = 0;

        String binary = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') cnt++;
        }

        for (int i = n + 1; i <= 1_000_000; i++) {
            String s = Integer.toBinaryString(i);
            int s_cnt = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') s_cnt++;
            }

            if (s_cnt == cnt) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
