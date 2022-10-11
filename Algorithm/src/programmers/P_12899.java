package programmers;

public class P_12899 {
    public static void main(String[] args) {

    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] converter = {"4", "1", "2"};

        while (n > 0) {
            int num = n % 3;

            answer.insert(0, converter[num]);
            n /= 3;

            if (num == 0) n--;
        }

        return answer.toString();
    }
}
