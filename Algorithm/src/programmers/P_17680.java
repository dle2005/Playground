package programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;

public class P_17680 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Deque<String> deque = new ArrayDeque<>();

        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);

            if (!deque.isEmpty() && deque.contains(city)) {
                deque.remove(city);
                deque.offerLast(city);
                answer += 1;
            } else {
                if(cacheSize != 0) {
                    if(deque.size() == cacheSize)
                        deque.pollFirst();
                    deque.offerLast(city);
                }
                answer += 5;
            }
        }

        return answer;
    }
}
