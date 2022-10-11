package LeetCode;

public class Zigzag_Conversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] zigzag = new StringBuilder[numRows];
        int idx = 0, cur_row = 0;
        boolean down = true;

        for (int i = 0; i < numRows; i++) {
            zigzag[i] = new StringBuilder();
        }

        while (idx != s.length()) {
            zigzag[cur_row].append(s.charAt(idx++));

            cur_row = down ? cur_row + 1 : cur_row - 1;
            down = (cur_row == numRows - 1 || cur_row == 0) != down;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder sb : zigzag) {
            answer.append(sb);
        }

        return answer.toString();
    }
}
