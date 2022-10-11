package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4358 {
    public static class Pair implements Comparable<Pair> {
        String name;
        String ratio;

        public Pair(String name, String ratio) {
            this.name = name;
            this.ratio = ratio;
        }

        @Override
        public int compareTo(Pair o) {
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        int total = 0;

        while (true) {
            String s = br.readLine();
            if(s == null || s.length() == 0)
                break; // 입력 종료

            if(map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else map.put(s, 1);

            total++;
        }

        List<Pair> list = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            Pair p = new Pair(m.getKey(), 
                    String.format("%.4f", ((double) m.getValue()/ total) * 100));
            list.add(p);
        }

        Collections.sort(list);

        for(Pair p : list)
            sb.append(p.name + " " + p.ratio).append("\n");

        System.out.println(sb);
    }
}
