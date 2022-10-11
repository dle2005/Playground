package programmers;

public class P_17682 {
    class Solution {
        public int solution(String dartResult) {
            int[] num = new int[3]; // 1
            int index = 0;

            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);

                if (Character.isDigit(c)) { // 2
                    if (c == '1' && dartResult.charAt(i + 1) == '0') {
                        num[index++] = Integer.parseInt(dartResult.substring(i, i + 2));
                        i++;
                    } else {
                        num[index++] = c - '0';
                    }
                } else { // 3
                    switch (c) {
                        case 'D' :
                            num[index - 1] = (int)Math.pow(num[index - 1], 2);
                            break;
                        case 'T' :
                            num[index - 1] = (int)Math.pow(num[index - 1], 3);
                            break;
                        case '*' :
                            if (index == 1) {
                                num[index - 1] *= 2;
                            } else {
                                num[index - 1] *= 2;
                                num[index - 2] *= 2;
                            }
                            break;
                        case '#' :
                            num[index - 1] *= -1;
                            break;
                    }
                }
            }

            int answer = 0;
            for (int n : num) {
                answer += n;
            }
            return answer;
        }
    }
}
