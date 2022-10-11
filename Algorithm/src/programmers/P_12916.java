package programmers;

public class P_12916 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }
    static boolean solution(String s) {
        boolean answer = true;

        int Pp = 0, Yy = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == 'P' || c == 'p') Pp++;
            else if(c == 'Y' || c == 'y') Yy++;
        }

        return answer = Pp == Yy ? true : false;
    }
}
