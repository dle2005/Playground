package programmers;

import java.util.*;

public class P_67258 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    }
    public static int[] solution(String[] gems) {
        int[] answer = {};

        // set 을 사용해서 보석의 종류 갯수를 파악
        Set<String> set = new HashSet<>();
        // 갯수만큼 포함하는 방식을 사용해서 찾으면 return 하고 종료
        for(int i = 0; i < gems.length; i++)
            set.add(gems[i]);

        // 보석 전체가 포함될때까지 포석을 추가
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        int start = 0, begin = 0, length = Integer.MAX_VALUE;

        for(int i = 0; i < gems.length; i++) {
            if(!map.containsKey(gems[i])) map.put(gems[i], 1);
            else map.put(gems[i], map.get(gems[i])+1);

            q.add(gems[i]);

            while(map.get(q.peek()) > 1) {
                map.put(q.peek(), map.get(q.peek()) - 1);
                q.poll();
                start++;
            }

            if(map.size() == set.size() && length > q.size()) {
                length = q.size();
                begin = start;
            }
        }

        // 어피치는 쇼핑을 할 때면 매장 진열대의 특정 범위의 물건들을 모두 싹슬이 구매하는 습관이 있습니다.
        // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매

        // 하나 이상 포함하는 가장 짧은 구간을 찾아서 return 하도록 solution 함수를 완성
        // 가장 짧은 구간의 '시작 진열대 번호' 와 '끝 진열대 번호' 를 차례대로 배열에 담아서 return
        /// 만약 가장 짧은 구간이 여러 개라면 '시작 진열대 번호' 가 가장 작은 구간을 return

//        System.out.println(answer[0] + " " + answer[1]);
        return new int[]{begin + 1, begin + length};
    }
}
