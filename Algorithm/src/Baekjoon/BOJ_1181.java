package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if (!list.contains(s))
                list.add(s);
        }

        Collections.sort(list, (x, y) -> {
            if(x.length() == y.length())
                return x.compareTo(y);
            else
                return x.length() - y.length();
        });

        Iterator<String> iterator = list.listIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}
