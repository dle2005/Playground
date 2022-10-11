package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> n_list = new ArrayList<>();

        for(int i = 0; i < N; i++)
            n_list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(n_list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            sb.append(b_search(n_list, m)).append("\n");
        }

        System.out.println(sb);
    }

    public static int b_search(List<Integer> list, int m) {
        if(m < list.get(0) || m > list.get(list.size()-1))
            return 0;

        int low = 0, high = list.size() -1;
        int mid = (low + high) / 2;

        while(low <= high) {
            if(m == list.get(mid))
                return 1;
            else if(m > list.get(mid)) {
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else {
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }

        return 0;
    }
}
