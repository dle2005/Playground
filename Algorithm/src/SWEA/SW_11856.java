package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SW_11856 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            String s = br.readLine();

            Map<Character, Integer> map = new HashMap<>();
            int cnt = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!map.containsKey(c)) map.put(c, 1);
                else {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 2) cnt++;
                }
            }

            if (cnt == 2) sb.append("#" + index + " " + "Yes" + "\n");
            else sb.append("#" + index + " " + "No" + "\n");
        }

        System.out.println(sb);
    }
}
