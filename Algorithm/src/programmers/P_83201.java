package programmers;

public class P_83201 {
    class Solution {
        public String solution(int[][] scores) {
            StringBuilder answer = new StringBuilder();

            for (int j = 0; j < scores[0].length; j++) {
                int min = Integer.MAX_VALUE;
                int max = 0;
                int self = -1;
                int total = 0;
                int count = scores.length;

                for (int i = 0; i < scores.length; i++) {
                    if (i == j) self = scores[i][j];
                    else {
                        max = Math.max(max, scores[i][j]);
                        min = Math.min(min, scores[i][j]);
                    }

                    total += scores[i][j];
                }

                if (self > max || self < min) {
                    total -= self;
                    count--;
                }

                answer.append(grade((double)total / count));
            }

            return answer.toString();
        }

        public char grade(double n) {
            if (n >= 90) return 'A';
            else if (n >= 80) return 'B';
            else if (n >= 70) return 'C';
            else if (n >= 50) return 'D';
            else return 'F';
        }
    }}
