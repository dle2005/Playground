package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class P_42890 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "1"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        }));
    }

    public static ArrayList<HashSet<Integer>> candidateKey = new ArrayList<>();

    public static int solution(String[][] relation) {
        int answer = 0;

        for(int i = 1; i <= relation[0].length; i++)
            dfs(0, i, 0, new HashSet<>(), relation);

        return answer = candidateKey.size();
    }

    public static void dfs(int depth, int size, int start, HashSet<Integer> combination, String[][] relation) {
        if(depth == size) {
            for(HashSet<Integer> key : candidateKey) {
                if(combination.containsAll(key)) return;
            }

            if(isPromise(combination, relation))
                candidateKey.add(combination);

            return;
        }

        for(int i = start; i < relation[0].length; i++) {
            HashSet<Integer> temp = new HashSet<>(combination);
            temp.add(i);
            dfs(depth + 1, size, i + 1, temp, relation);
        }
    }

    public static boolean isPromise(HashSet<Integer> combination, String[][] relation) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();

            for(int j : combination)
                sb.append(relation[i][j]);

            if(set.contains(sb.toString())) return false;

            set.add(sb.toString());
        }

        return true;
    }
}
