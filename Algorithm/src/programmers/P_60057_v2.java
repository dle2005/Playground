package programmers;

public class P_60057_v2 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int len = 0, j = 0;

            for ( ; j <= s.length() - i; ) {
                String unit = s.substring(j, j + i);

                int cnt = 0;
                for ( ; j <= s.length() - i; j += i) {
                    if (unit.equals(s.substring(j, j + i))) {
                        cnt++;
                    } else {
                        break;
                    }
                }

                if (cnt == 1) {
                    len += i;
                }
                else {
                    len += (String.valueOf(cnt).length() + 1);
                }
            }

            len += s.length() - j;
            answer = Math.min(answer, len);
        }

        return answer;
    }
}
