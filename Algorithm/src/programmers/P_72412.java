package programmers;

import java.util.*;

public class P_72412 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"
                }, new String[]{"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150",
                "java and frontend and - and - 150"})));
    }

    public static String[] com = new String[4];

    public static int[] solution(String[] infos, String[] queries) {
        int[] answer = new int[queries.length];
        Map<String, List<Integer>> scores = new HashMap<>();

        for (String info : infos) {
            String[] detail = info.split(" ");

            addScore(0, detail, scores);
        }

        for (String key : scores.keySet()) {
            Collections.sort(scores.get(key));
        }

        for (int i = 0; i < queries.length; i++) {
            String[] detail = queries[i].split(" ");

            String key = detail[0] + detail[2] + detail[4] + detail[6];
            int score = Integer.parseInt(detail[7]);

            if (scores.containsKey(key)) {
                int idx = binarySearch(score, scores.get(key));
                answer[i] = scores.get(key).size() - idx;
            }
        }

        return answer;
    }

    public static int binarySearch(int score, List<Integer> data) {
        int left = 0, right = data.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (data.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void addScore(int depth, String[] detail, Map<String, List<Integer>> scores) {
        if (depth == 4) {
            String key = com[0] + com[1] + com[2] + com[3];
            int score = Integer.parseInt(detail[4]);

            if (!scores.containsKey(key)) {
                scores.put(key, new ArrayList<>());
            }
            scores.get(key).add(score);

            return;
        }

        com[depth] = detail[depth];
        addScore(depth + 1, detail, scores);

        com[depth] = "-";
        addScore(depth + 1, detail, scores);
    }
}
