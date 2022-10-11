package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_42889_v2 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] users = new int[N + 2];
            for (int n : stages) {
                users[n]++;
            }

            int pass_user = stages.length;
            List<Pair> failure = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                failure.add(new Pair((double)users[i] / pass_user, i));
                pass_user -= users[i];
            }

            Collections.sort(failure);

            int[] answer = new int[N];
            for (int i = 0; i < N; i++) {
                answer[i] = failure.get(i).index;
            }

            return answer;
        }

        class Pair implements Comparable<Pair>{
            double failure;
            int index;

            public Pair(double failure, int index) {
                this.failure = failure;
                this.index = index;
            }

            @Override
            public int compareTo(Pair o) {
                if (this.failure > o.failure) {
                    return -1;
                } else if (this.failure < o.failure) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
