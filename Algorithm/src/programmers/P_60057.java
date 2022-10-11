package programmers;

public class P_60057 {
    public static void main(String[] args) {
        System.out.println(solution("abbbcccabcdede"));
    }
    public static int solution(String s) {
        int answer = s.length();

        // i는 문자열을 자를 단위
        for(int i = 1; i <= s.length()/2; i++) {

            String temp = "";
            int j_index = 0;
            // j는 문자열 s를 탐색할 위치
            for(int j = 0; j < s.length() - i+1;) {

                // 같은 패턴이 몇개 존재할지 탐색할 문자열
                String unit = s.substring(j,j+i);

                int cnt = 0;
                // 패턴이 몇개 존재하는지 탐색
                for(;j < s.length() - i+1; j+=i) {
                    String compare = s.substring(j, j+i);
                    if(unit.equals(compare)) cnt++;
                    else break;
                }

                //바꿀 문자열
                String change;
                if(cnt == 1) change = unit;
                else change = cnt + unit;

                temp += change;
                j_index = j;
            }

            temp += s.substring(j_index);

            answer = Math.min(answer, temp.length());
        }

        return answer;
    }
}
