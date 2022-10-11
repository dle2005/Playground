package programmers;

public class P_92342 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
        solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
    }

    public static int max = 0, min = 0;
    public static int[] result = new int[11];
    public static int[] answer;

    public static int[] solution(int n, int[] info) {
        answer = new int[11];

        backTracking(0, 0, n, info);

        if (max == 0) answer = new int[]{-1};

        return answer;
    }

    public static void backTracking(int index, int cnt, int n, int[] info) {
        if (index == 11 || cnt == n) {
            if (index == 11 && cnt != n) result[10] = n - cnt;
            int calc = calculate(result, info);
            if (max < calc) {
                answer = result.clone();
                max = calc;
                min = smallScore(result);
            } else if (max == calc) {
                if (min > smallScore(result)) {
                    answer = result.clone();
                    max = calc;
                    min = smallScore(result);
                }
            }
            if (index == 11 && cnt != n) result[10] = 0;
            return;
        }

        if (cnt + info[index] + 1 <= n) {
            result[index] = info[index] + 1;
            backTracking(index + 1, cnt + info[index] + 1, n, info);
            result[index] = 0;
        }
        backTracking(index + 1, cnt, n, info);
    }

    public static int calculate(int[] arr, int[] info) {
        int apeach = 0, ryon = 0;
        for (int i = 0, score = 10; i <= 10; i++, score--) {
            if (arr[i] == 0 && info[i] == 0) continue;

            if (arr[i] > info[i]) ryon += score;
            else apeach += score;
        }
        return ryon - apeach;
    }

    public static int smallScore(int[] arr) {
        int sum = 0;
        for (int i = 0, score = 10; i <= 10; i++, score--) {
            sum += arr[i] * score;
        }
        return sum;
    }
}
