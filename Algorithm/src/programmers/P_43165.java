package programmers;

public class P_43165 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public static int[] operator;
    public static int cnt = 0;

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        operator = new int[numbers.length];

        dfs(0, numbers, target);

        return answer = cnt;
    }
    public static void dfs(int depth, int[] numbers, int target) {
        if(depth == numbers.length) {
            int sum = 0;
            for(int i = 0; i < numbers.length; i++) {
                if(operator[i] == 0) sum += numbers[i];
                else sum -= numbers[i];
            }

            if(sum == target) cnt++;

            return;
        }

        for(int i = 0; i < 2; i++) {
            operator[depth] = i;
            dfs(depth + 1, numbers, target);
        }
    }
}
