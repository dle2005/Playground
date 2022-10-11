package programmers;

import java.util.Arrays;

public class P_42885 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int low = 0, high = people.length - 1;
        while(low <= high) {
            if(people[low] + people[high] > limit) {
                answer++; high--;
            }
            else if(people[low] + people[high] <= limit) {
                answer++; low++; high--;
            }
            else {
                high--; answer++;
            }
        }

        return answer;
    }
}
