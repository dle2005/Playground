package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> list = new LinkedList<>();
        String arr = br.readLine();
        for(int i = 0; i < arr.length(); i++)
            list.add(arr.charAt(i));
        ListIterator<Character> iterator = list.listIterator(list.size());
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String st = br.readLine();
            char c = st.charAt(0);

            switch (c) {
                case 'L' :
                    if(iterator.hasPrevious())
                        iterator.previous();
                    break;
                case 'D' :
                    if(iterator.hasNext())
                        iterator.next();
                    break;
                case 'B' :
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P' :
                    iterator.add(st.charAt(2));
                    break;
            }
        }

        for(Character c : list)
            bw.write(c);

        bw.flush();
    }
}
