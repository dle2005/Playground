package programmers;

public class P_12977 {
    public static void main(String[] args) {

    }
    public static int answer = 0;
    public static boolean[] isPrime;

    public static int solution(int[] nums) {
        isPrime = new boolean[3001];

        eratostenes();

        dfs(0, 0, 0, nums);

        return answer;
    }

    public static void eratostenes() {
        for (int i = 2; i <= 3000; i++) isPrime[i] = true;

        for (int i = 2; i * i <= 3000; i++) {
            for (int j = i * i; j <= 3000; j += i) isPrime[j] = false;
        }
    }

    public static void dfs(int depth, int start, int sum, int[] nums) {
        if (depth == 3) {
            if (isPrime[sum]) answer++;
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int cur = sum;
            dfs(depth + 1, i + 1, cur += nums[i], nums);
        }
    }
}
