package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_42889 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{3, 3, 3, 3}));
    }
    public static class ratio {
        double r;
        int index;

        public ratio(double r, int index) {
            this.r = r;
            this.index = index;
        }
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = {};

        int[] pass = new int[N+2];
        int[] stay = new int[N+2];

        for (int i = 0; i < stages.length; i++) {
            int n = stages[i];

            for (int j = 1; j < n; j++) pass[j]++;

            stay[n]++;
        }

        List<ratio> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            double r = 0.0;

            if(stay[i] == 0 && pass[i] == 0) {}
            else r = (double) stay[i] / pass[i];

            list.add(new ratio(r, i));
        }

        for(ratio r : list) System.out.println(r.r);

        Collections.sort(list, new Comparator<ratio>() {
            @Override
            public int compare(ratio o1, ratio o2) {
                if(o2.r == o1.r)
                    return o1.index - o2.index;
                else {
                    if(o1.r > o2.r) return -1;
                    else return 1;
                }
            }
        });

        List<Integer> result = new ArrayList<>();
        for(ratio r : list) result.add(r.index);

        for(int i : result) System.out.print(i + " ");

        return answer = result.stream().mapToInt(Integer::intValue).toArray();
    }
}
