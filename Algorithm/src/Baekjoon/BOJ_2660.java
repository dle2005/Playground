package Baekjoon;

import java.util.*;

public class BOJ_2660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer>[] list = new List[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        int[] max = new int[N+1];

        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == -1 && b == -1)
                break;

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i <= N; i++) {
            boolean[] visit = new boolean[N+1];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, 0});
            visit[i] = true;

            while(!queue.isEmpty()) {
                int[] q = queue.poll();
                max[i] = Math.max(max[i], q[1]);

                for(int j : list[q[0]]) {
                    if(!visit[j]) {
                        queue.offer(new int[]{j, q[1] + 1});
                        visit[j] = true;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++)
            min = Math.min(min, max[i]);

        List<Integer> v = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(max[i] == min) v.add(i);
        }

        System.out.println(min + " " + v.size());
        for(int i : v)
            System.out.print(i + " ");
    }
}
