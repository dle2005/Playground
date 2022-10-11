package programmers;

import java.util.HashMap;
import java.util.Map;

public class P_70130 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0}));
        System.out.println(solution(new int[]{5,2,3,3,5,3}));
        System.out.println(solution(new int[]{0,3,3,0,7,2,0,2,2,0}));
    }
    public static int solution(int[] a) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 1, num = -1;
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])) {
                if(a[i - 1] == a[i] && i + 1 < a.length && a[i] == a[i + 1]) continue;
                map.put(a[i], map.get(a[i]) + 1);
                if (max <= map.get(a[i])) {
                    max = map.get(a[i]);
                    num = a[i];
                }
            } else map.put(a[i], 1);
        }

        for (int i = 0; i < a.length; i++) {
            if (i == 0 && a[i] == num) {
                if (a[i + 1] != num) {
                    answer += 2;
                    a[i] = a.length + 1;
                    a[i + 1] = a.length + 1;
                }
            } else if (i == a.length - 1 && a[i] == num) {
                if (a[i - 1] != num && a[i - 1] != a.length + 1) {
                    answer += 2;
                }
            } else if (a[i] == num) {
                if (a[i - 1] != num && a[i - 1] != a.length + 1) {
                    answer += 2;
                    a[i - 1] = a.length + 1;
                    a[i] = a.length + 1;
                } else if (a[i + 1] != num && a[i + 1] != a.length + 1) {
                    answer += 2;
                    a[i] = a.length + 1;
                    a[i + 1] = a.length + 1;
                }
            }
        }

        return answer;
    }
}
