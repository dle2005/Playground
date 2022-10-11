package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] woof = br.readLine().split(" ");

            List<String> list = new ArrayList<>();
            List<String> delete_list = new ArrayList<>();
            for (int i = 0; i < woof.length; i++)
                list.add(woof[i]);

            while (true) {
                String s = br.readLine();

                if (s.equals("what does the fox say?")) {
                    list.removeAll(delete_list);

                    for (String t : list)
                        sb.append(t).append(" ");
                    sb.append("\n");
                    
                    break;
                } else {
                    String[] arr = s.split(" ");

                    delete_list.add(arr[2]);
                }
            }
        }

        System.out.println(sb);
    }
}
