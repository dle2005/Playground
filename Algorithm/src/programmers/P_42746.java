package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class P_42746 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
    }
    public static String solution(int[] numbers) {
        String answer = "";

        String[] s_numbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            s_numbers[i] = String.valueOf(numbers[i]);

        Arrays.sort(s_numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(s_numbers[0].equals("0"))
            return "0";


        for(int i = 0; i < numbers.length; i++)
            answer += s_numbers[i];

        return answer;
    }
}
