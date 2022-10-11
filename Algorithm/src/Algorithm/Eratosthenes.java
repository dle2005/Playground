package Algorithm;

public class Eratosthenes {
    public static boolean[] isPrime = new boolean[1_000_001];

    public static void eratosthenes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 1_000_000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 1_000_000; j += i)
                    isPrime[j] = true;
            }
        }
    }

}
