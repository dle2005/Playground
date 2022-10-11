package programmers;

public class P_70129 {
    public static void main(String[] args) {
        System.out.println(solution("110010101001"));
        System.out.println(solution("01110"));
        System.out.println(solution("1111111"));
    }
    public static int[] solution(String s) {
        int[] answer = {};

        int zeros = 0, cnt = 0;

        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') zeros++;
                else sb.append(s.charAt(i));
            }

            s = sb.toString();

//            System.out.print(s);

            s = Integer.toBinaryString(s.length());

//            System.out.println(" " + s);
            cnt++;
        }

//        System.out.println(cnt + " " + zeros);
        return answer = new int[]{cnt, zeros};
    }
}
