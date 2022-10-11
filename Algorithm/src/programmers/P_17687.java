package programmers;

public class P_17687 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }
    public static String solution(int n, int t, int m, int p) {
        StringBuilder convertedStr = new StringBuilder();
        for (int num = 0; convertedStr.length() < t * m; num++) {
            convertedStr.append(convertNumber(n, num));
        }

        StringBuilder answer = new StringBuilder();
        for (int idx = p - 1; idx < t * m; idx += m) {
            answer.append(toUpperCase(convertedStr.charAt(idx)));
        }

        return answer.toString();
    }

    public static char toUpperCase(char c) {
        if (Character.isDigit(c)) {
            return c;
        } else {
            return Character.toUpperCase(c);
        }
    }

    public static String convertNumber(int n, int num) {
        return Integer.toString(num, n);
    }
}
