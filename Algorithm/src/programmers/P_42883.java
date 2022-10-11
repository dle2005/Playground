package programmers;

public class P_42883 {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("3177252841", 4));
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int max = 0, max_index = 0;

        for (int i = 0; i < number.length() - k; i++) {
            max = 0;

            for (int j = max_index; j <= i + k; j++) {
                int n = Character.getNumericValue(number.charAt(j));

                if (n > max) {
                    max = n;
                    max_index = j + 1;
                }
            }

            sb.append(max);
        }

        return sb.toString();
    }
}
