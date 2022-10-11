package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

            while(k-- > 0) {
                String[] input = br.readLine().split(" ");
                char operation = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (operation == 'I') {
                    minQueue.offer(n);
                    maxQueue.offer(n);

                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if(map.size() == 0) continue;

                    PriorityQueue<Integer> deleteQueue = n == 1 ? maxQueue : minQueue;
                    remove(deleteQueue, map);
                }
            }

            if(map.size() == 0) sb.append("EMPTY").append("\n");
            else {
                int max = remove(maxQueue, map);
                
                if(map.size() == 0)
                    sb.append(max + " " + max).append("\n");
                else {
                    int min = remove(minQueue, map);
                    sb.append(max + " " + min).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static int remove(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        int num;

        while (true) {
            num = queue.poll();

            int cnt = map.getOrDefault(num, 0);

            if (cnt == 1) {
                map.remove(num);
                break;
            } else if (cnt > 1) {
                map.put(num, cnt - 1);
                break;
            }
        }

        return num;
    }
}
