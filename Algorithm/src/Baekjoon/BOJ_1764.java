package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1764 {
    public static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < N; i++)
            list.add(br.readLine());

        Collections.sort(list);

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(bSearch(s)) {
                answer.add(s);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(String s : answer)
            System.out.println(s);
    }

    public static boolean bSearch(String s) {
        int low = 0, high = list.size() - 1;
        int mid = (low + high) / 2;

        while(low <= high) {
            if(s.equals(list.get(mid)))
                return true;
            else if(s.compareTo(list.get(mid)) < 0) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
            else {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }

        return false;
    }
}
