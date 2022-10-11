package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2056 {
    public static void main(String[] args) throws IOException {
        // 수행해야 할 작업 N개 (3 <= N <= 10,000)
        // 각각의 작업마다 걸리는 시간 (1 <= 시간 <= 100)

        // 몇몇 작업들 사이에는 선행 관계라는게 있어서, ---> 위상정렬
        // 어떤 작업을 수행하기 위해 반드시 먼저 완료되어야 할 작업들이 있다.

        // K번 작업에 대한 선행 관계에 있는 작업들의 번호는 모두 1 이상 K-1 이하
        // 선행 관계에 있는 작업이 하나도 없는 작업이 반드시 하나 이상 존재한다.
        // 1번 작업이 항상 그러하다

        // 모든 작업을 완료하기 위해 필요한 최소 시간을 구하여라
        // 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N]; // 소요시간 저장
        List<Integer>[] list = new List[N]; // 인접리스트
        for(int i = 0; i < N; i++)
            list[i] = new ArrayList<>();
        int[] degree = new int[N]; // 차수 저장

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken()); // 소요시간
            degree[i] = Integer.parseInt(st.nextToken()); // 선행작업 수

            for(int j = 0; j < degree[i]; j++) { // 선행작업들 저장
                int pre = Integer.parseInt(st.nextToken()) - 1;
                list[pre].add(i);
            }
        }

        // 다음 차수로 이동하면서 소요시간을 dp 배열로 저장
        int[] dp = new int[N];

        // queue 를 사용해서 bfs 탐색
        Queue<Integer> queue = new LinkedList<>();

        // 차수가 0인 작업이 여럿일 수 있으므로 전부 queue 에 저장
        for(int i = 0; i < N; i++) {
            dp[i] = time[i];

            if(degree[i] == 0)
                queue.offer(i);
        }

        // 차수가 0인 것부터 탐색을 하면서
        // 작업이 완료되면 소요시간을 갱신해 주고, 차수가 감소
        // 차수가 0이 되면 그 작업에서 부터 검사하는것을 반복
        while (!queue.isEmpty()) {
            int q = queue.poll();

            for(int next : list[q]) {
                // 다음 노드는 앞에 작업을 전부 완료해야 하므로
                // 그 중에서 가장 오래 걸리는 시간만큼 소모 됨
                dp[next] = Math.max(dp[next], time[next] + dp[q]);

                // 앞의 작업이 완료되었으므로 차수를 감소
                degree[next]--;

                // 차수가 0이 되며 종단이 되므로 queue 에 추가
                if(degree[next] == 0)
                    queue.offer(next);
            }
        }

        int result = 0;
        for(int i : dp)
            result = Math.max(result, i);
        System.out.println(result);
    }
}
