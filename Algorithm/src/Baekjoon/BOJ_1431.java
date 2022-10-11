package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(br.readLine());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    int sum1 = 0, sum2 = 0;

                    for(int i = 0; i < o1.length(); i++) {
                        if('0' <= o1.charAt(i) && o1.charAt(i) <= '9')
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        if('0' <= o2.charAt(i) && o2.charAt(i) <= '9')
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                    }

                    if(sum1 == sum2)
                        return o1.compareTo(o2);
                    else return Integer.compare(sum1, sum2);
                }
                else return o1.length() - o2.length();
            }
        });

        for(String s : list)
            System.out.println(s);
    }
}
