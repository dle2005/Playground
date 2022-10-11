package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9177 {
    public static char[] word1, word2, word3;
    public static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            word1 = st.nextToken().toCharArray();
            word2 = st.nextToken().toCharArray();
            word3 = st.nextToken().toCharArray();

            flag = false; // dfs에서 결과를 찾은 경우 더 이상 탐색을 하지 않게 하기 위해서

            // word1과 2의 문자가 3에 존재하는지 검사
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < Math.max(word1.length, word2.length); j++) {
                if(j < word1.length) set.add(word1[j]);
                if(j < word2.length) set.add(word2[j]);
            }

            boolean contain = true;
            for(int j = 0; j < word3.length; j++) {
                if(!set.contains(word3[j])) {
                    contain = false;
                    break;
                }
            }

            // word1과 2의 문자가 3에 없다면 data set 존재 여부 검사할 필요가 없음
            if(!contain) {
                sb.append("Data set " + i + ": no").append("\n");
                continue;
            }

            dfs(0, 0, 0);

            if(flag) // data set 존재 여부 판별
                sb.append("Data set " + i + ": yes").append("\n");
            else
                sb.append("Data set " + i + ": no").append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int i1, int i2, int i3) {
        if(flag) return; // 결과를 찾은 경우 더 이상 탐색 하지 않음

        if(i3 == word3.length) {
            flag = true;
            return;
        }

        // word1과 word2의 단어가 word3에 없는경우 종료
        // 이렇게 검사하니 시간초과가 났음
//        if(i1 < word1.length && i2 < word2.length && word3[i3] != word1[i1] && word3[i3] != word2[i2])
//            return;

        // word1or2의 문자와 word3의 문자가 일치하는 경우
        // 모든 경우를 탐색해서 결과와 일치하는지 검사
        if(i1 < word1.length && word3[i3] == word1[i1])
            dfs(i1+1, i2, i3+1);
        if(i2 < word2.length && word3[i3] == word2[i2])
            dfs(i1, i2+1, i3+1);
    }
}
