package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String st = br.readLine();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();

            for(int j = 0; j < st.length(); j++) {
                char c = st.charAt(j);

                switch (c) {
                    case '<' :
                        if(iterator.hasPrevious())
                            iterator.previous();
                        break;
                    case '>' :
                        if(iterator.hasNext())
                            iterator.next();
                        break;
                    case '-' :
                        if(iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default :
                        iterator.add(c);
                }
            }

            for(Character c : list)
                sb.append(c);

            System.out.println(sb);
        }
    }
}
