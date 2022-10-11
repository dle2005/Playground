package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < K; i++) {
            if (!set.contains(arr[i])) {
                if (N <= set.size()) {
                    List<Integer> list = new ArrayList<>();
                    Set<Integer> remain = new HashSet<>(set);

                    for (int j = i; j < K; j++) {
                        if (set.contains(arr[j]) && !list.contains(arr[j])) {
                            list.add(arr[j]);
                            remain.remove(arr[j]);
                        }
                    }

                    if (list.size() == N) {
                        set.remove(list.get(list.size() - 1));
                    } else {
                        List<Integer> temp = new ArrayList<>(remain);
                        set.remove(temp.get(0));
                    }

                    answer++;
                }

                set.add(arr[i]);
            }
        }

        System.out.println(answer);
    }
}
