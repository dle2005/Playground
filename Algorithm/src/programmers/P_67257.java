package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_67257 {
    public static Set<Character> set_calculate = new HashSet<>();
    public static List<Character> calculate;
    public static List<String> exp = new ArrayList<>();
    public static char[] calc;
    public static boolean[] include;
    public static long answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(solution("300*200*300"));
    }
    public static long solution(String expression) {

        int index = 0;
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                set_calculate.add(c);
                exp.add(expression.substring(index, i));
                exp.add(String.valueOf(c));
                index = i+1;
            }
        }
        exp.add(expression.substring(index));

        calculate = new ArrayList<>(set_calculate);
        calc = new char[calculate.size()];
        include = new boolean[calculate.size()];

        makeOrder(0);

        return answer;
    }

    public static void calculation() {
        List<String> temp = new ArrayList<>(exp);

        for(int i = 0; i < calculate.size(); i++) {
            char c = calc[i];

            for(int j = 1; j < temp.size()-1; j++) {
                if(temp.get(j).equals(String.valueOf(c))) {
                    long a = Long.parseLong(temp.get(j-1));
                    long b = Long.parseLong(temp.get(j+1));

                    if(c == '+') a += b;
                    if(c == '-') a -= b;
                    if(c == '*') a *= b;

                    temp.set(j-1, String.valueOf(a));
                    temp.remove(j);
                    temp.remove(j);
                    j-=2;
                }
            }
        }


        answer = Math.max(Math.abs(Long.parseLong(temp.get(0))), answer);
    }

    public static void makeOrder(int depth) {
        if(depth == calculate.size()) {
            calculation();
            return;
        }

        for(int i = 0; i < calculate.size(); i++) {
            if(!include[i]) {
                include[i] = true;
                calc[depth] = calculate.get(i);
                makeOrder(depth+1);
                include[i] = false;
            }
        }
    }
}
