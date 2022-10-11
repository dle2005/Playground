package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1062 {
    public static int N, K, result = 0;
    public static String[] words;
    public static boolean[] alp = new boolean[26];
    public static Set<Character> set = new HashSet<>();
    public static ArrayList<Character> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 단어의 수
        K = Integer.parseInt(st.nextToken()); // K개의 글자

        // anta tica는 최소 5개의 단어가 필요함
        if(K < 5) {
            System.out.println(0);
            return;
        }

        if(K == 26) {
            System.out.println(N);
            return;
        }

        alp['a' - 'a'] = true; // anta tica에 들어가는 알파벳은
        alp['n' - 'a'] = true; // 이미 포함으로 초기화
        alp['t' - 'a'] = true;
        alp['i' - 'a'] = true;
        alp['c' - 'a'] = true;

        // 단어에서 anta tica를 제외하고 저장
        words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();

            words[i] = words[i].substring(4, words[i].length()-4);
            words[i] = words[i].replaceAll("a", "");
            words[i] = words[i].replaceAll("n", "");
            words[i] = words[i].replaceAll("t", "");
            words[i] = words[i].replaceAll("i", "");
            words[i] = words[i].replaceAll("c", "");

//            for(int j = 0; j < words[i].length(); j++)
//                set.add(words[i].charAt(j)); // set에 저장
        }

//        list = new ArrayList<>(set);

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int start, int depth) {
        if(depth == K-5) {
            getCount();
            return;
        }

        for(int i = start; i < 26; i++) {
            if(!alp[i]) {
                alp[i] = true;
                dfs(i, depth+1);
                alp[i] = false;
            }
        }
    }

    public static void getCount() {
        int count = 0;

        // 알파벳을 K-5개 더 배운 상태에서 몇 개의 단어가 사용 가능한지 확인
        for(int i = 0; i < N; i++) { // 모든 단어 검사
            boolean flag = true;

            for(int j = 0; j < words[i].length(); j++) {
                if(!alp[words[i].charAt(j) - 'a']) {
                    flag =false;
                    break;
                }
            }

            if(flag) count++; // 단어가 사용 가능하면 증가
        }

        result  = Math.max(result, count); // 모든 단어 탐색후 최대값 갱신
    }
}
