package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class BOJ_1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[5][N];

        Set[] dupCheckSet = new Set[N];
        int max = 0, answer = 1;

        for (int j = 0; j < N; j++) {
            dupCheckSet[j] = new HashSet();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            Map<Integer, List<Integer>> stuClsMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                List<Integer> value = stuClsMap.getOrDefault(arr[i][j], new ArrayList<>());
                value.add(j);

                stuClsMap.put(arr[i][j], value);
            }

            for (Entry<Integer, List<Integer>> entry : stuClsMap.entrySet()) {
                if (entry.getValue().size() > 1) {
                    for (int stuN : entry.getValue()) {
                        dupCheckSet[stuN].addAll(entry.getValue());
                        dupCheckSet[stuN].remove(stuN);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dupCheckSet[i].size() > max) {
                max = dupCheckSet[i].size();
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}
