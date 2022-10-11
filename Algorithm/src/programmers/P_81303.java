package programmers;

import java.util.Stack;

public class P_81303 {
    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }
    public static String solution(int n, int k, String[] commands) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> garbage = new Stack<>();
        int pos = k, size = n;

        for (String command : commands) {
            String[] cmd = command.split(" ");

            if (cmd.length == 2) {
                int dis = Integer.parseInt(cmd[1]);
                pos += cmd[0].equals("D") ? dis : -dis;
            } else {
                if (cmd[0].equals("C")) {
                    garbage.add(pos);

                    size--;
                    pos = Math.min(pos, size - 1);
                } else {
                    if (garbage.pop() <= pos) {
                        pos++;
                    }

                    size++;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            answer.append("O");
        }
        while (!garbage.isEmpty()) {
            answer.insert(garbage.pop(), "X");
        }
        return answer.toString();
    }
}
