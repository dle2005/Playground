package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P_92335 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1_000_000; i++) {
            for (int j = 3; j <= 10; j++) {
                solution(i, j);
            }
        }
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String antilogarithm = getAntilogarithmString(n, k);

        List<Long> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(antilogarithm, "0");
        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());

            list.add(num);
        }

        for (long num : list) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(long n) {
        if (n == 0) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static String getAntilogarithmString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }
}
