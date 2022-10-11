package programmers;

public class P_67256 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
    public static class Hand {
        int i;
        int j;

        public Hand(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void setHand(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        Hand left = new Hand(3,0), right = new Hand(3, 2);
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                if(numbers[i] == 1) left.setHand(0,0);
                if(numbers[i] == 4) left.setHand(1,0);
                if(numbers[i] == 7) left.setHand(2, 0);
                answer += "L";
            }
            if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                if(numbers[i] == 3) right.setHand(0,2);
                if(numbers[i] == 6) right.setHand(1,2);
                if(numbers[i] == 9) right.setHand(2, 2);
                answer += "R";
            }

            if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
                int l_d = 0, r_d = 0;

                if(numbers[i] == 2) {
                    l_d = Math.abs(0 - left.i) + Math.abs(1 - left.j);
                    r_d = Math.abs(0 - right.i) + Math.abs(1 - right.j);

                    if(l_d == r_d) {
                        if(hand.equals("right")) {
                            right.setHand(0, 1);
                            answer += "R";
                        }
                        else {
                            left.setHand(0,1);
                            answer += "L";
                        }
                    }
                    else if(l_d > r_d) {
                        right.setHand(0, 1);
                        answer += "R";
                    }
                    else {
                        left.setHand(0, 1);
                        answer += "L";
                    }
                }
                if(numbers[i] == 5) {
                    l_d = Math.abs(1 - left.i) + Math.abs(1 - left.j);
                    r_d = Math.abs(1 - right.i) + Math.abs(1 - right.j);

                    if(l_d == r_d) {
                        if(hand.equals("right")) {
                            right.setHand(1, 1);
                            answer += "R";
                        }
                        else {
                            left.setHand(1,1);
                            answer += "L";
                        }
                    }
                    else if(l_d > r_d) {
                        right.setHand(1, 1);
                        answer += "R";
                    }
                    else {
                        left.setHand(1, 1);
                        answer += "L";
                    }
                }
                if(numbers[i] == 8) {
                    l_d = Math.abs(2 - left.i) + Math.abs(1 - left.j);
                    r_d = Math.abs(2 - right.i) + Math.abs(1 - right.j);

                    if(l_d == r_d) {
                        if(hand.equals("right")) {
                            right.setHand(2, 1);
                            answer += "R";
                        }
                        else {
                            left.setHand(2,1);
                            answer += "L";
                        }
                    }
                    else if(l_d > r_d) {
                        right.setHand(2, 1);
                        answer += "R";
                    }
                    else {
                        left.setHand(2, 1);
                        answer += "L";
                    }
                }
                if(numbers[i] == 0) {
                    l_d = Math.abs(3 - left.i) + Math.abs(1 - left.j);
                    r_d = Math.abs(3 - right.i) + Math.abs(1 - right.j);

                    if(l_d == r_d) {
                        if(hand.equals("right")) {
                            right.setHand(3, 1);
                            answer += "R";
                        }
                        else {
                            left.setHand(3,1);
                            answer += "L";
                        }
                    }
                    else if(l_d > r_d) {
                        right.setHand(3, 1);
                        answer += "R";
                    }
                    else {
                        left.setHand(3, 1);
                        answer += "L";
                    }
                }
            }
        }

        return answer;
    }
}
