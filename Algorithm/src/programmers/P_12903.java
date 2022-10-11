package programmers;

public class P_12903 {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));
    }
    public static String solution(String s) {
        String answer = "";

        if(s.length() % 2 == 0)
            answer = s.substring(s.length()/2-1, s.length()/2 + 1);
        else answer = s.substring(s.length()/2, s.length()/2 + 1);

        return answer;
    }
}
