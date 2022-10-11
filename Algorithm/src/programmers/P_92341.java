package programmers;

import java.util.*;

public class P_92341 {
    public static void main(String[] args) {
//        solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"});
    }
    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> park_car = new HashMap<>();
        Map<String, Integer> total_time = new HashMap<>();

        for (String record : records) {
            String[] park_info = record.split(" ");
            String time = park_info[0];
            String car_num = park_info[1];
            String division = park_info[2];

            if (division.equals("IN")) {
                park_car.put(car_num, time);
            } else {
                total_time.put(car_num, total_time.getOrDefault(car_num, 0) + calculateTime(park_car.get(car_num), time));

                park_car.remove(car_num);
            }
        }

        park_car.forEach((k, v) -> total_time.put(k, total_time.getOrDefault(k, 0) + calculateTime(v, "23:59")));

        List<String> car_list = new ArrayList<>(total_time.keySet());
        Collections.sort(car_list);

        int[] answer = new int[car_list.size()];
        for (int i = 0; i < car_list.size(); i++) {
            answer[i] = calculateFee(fees, total_time.get(car_list.get(i)));
        }

        return answer;
    }

    public static int calculateTime(String start_str, String end_str) {
        String[] start_hm = start_str.split(":");
        String[] end_hm = end_str.split(":");

        int start = Integer.parseInt(start_hm[0]) * 60 + Integer.parseInt(start_hm[1]);
        int end = Integer.parseInt(end_hm[0]) * 60 + Integer.parseInt(end_hm[1]);

        return end - start;
    }

    public static int calculateFee(int[] fees, int time) {
        if (time < fees[0]) {
            return fees[1];
        } else {
            return (int) (fees[1] + Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3]);
        }
    }
}
