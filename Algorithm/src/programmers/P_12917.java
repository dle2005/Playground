package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_12917 {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
    public static String solution(String s) {
        String answer = "";

        List<Character> alp = new ArrayList<>();
        List<Character> ALP = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if('a' <= c && c <= 'z') alp.add(c);
            else if('A' <= c && c <= 'Z') ALP.add(c);
        }

        Collections.sort(alp, Collections.reverseOrder());
        Collections.sort(ALP, Collections.reverseOrder());

        for(char c : alp) answer += c;
        for(char c : ALP) answer += c;

        return answer;
    }
}
