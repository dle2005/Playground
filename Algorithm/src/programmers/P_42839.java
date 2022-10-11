package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_42839 {
    public static void main(String[] args) {

    }
    public static boolean[] isPrime, visit;
    public static int answer;
    public static Set<Integer> set = new HashSet<>();

    public static int solution(String numbers) {
        erastotenes();

        visit = new boolean[numbers.length()];
        permutation("0", numbers);

        return answer;
    }

    public static void permutation(String s, String numbers) {
        int n = Integer.parseInt(s);

        if (isPrime[n]) {
            if (!set.contains(n)) {
                set.add(n);
                answer++;
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visit[i]) continue;

            visit[i] = true;
            String t = s + String.valueOf(numbers.charAt(i));
            permutation(t, numbers);
            visit[i] = false;
        }
    }

    public static void erastotenes() {
        isPrime = new boolean[10_000_000];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < 10_000_000; i++) {
            for (int j = i * i; j < 10_000_000; j += i)
                isPrime[j] = false;
        }

        isPrime[0] = isPrime[1] = false;
    }
}
