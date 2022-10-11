package programmers;

public class P_64062 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
    public static int solution(int[] stones, int k) {
        int answer = 0;

        int low = 1, high = 200000000;

        while(low <= high) {
            int mid = (low + high) / 2;

            int cnt = 0;

            for(int stone : stones) {
                if(stone < mid) cnt++;
                else cnt = 0;

                if(cnt == k) break;
            }

            if(cnt == k) high = mid - 1;
            else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }

        }

        return answer;
    }
}
