package programmers;

import java.util.*;

public class P_42888 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        }));
    }
    public static class Chat {
        String uid;
        String state;

        public Chat(String uid, String state) {
            this.uid = uid;
            this.state = state;
        }
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        StringTokenizer st;
        Map<String, String> map = new HashMap<>();
        Map<String, String> backup = new HashMap<>();
        List<Chat> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");

            if(input[0].equals("Enter")) {
                if(!map.containsKey(input[1])) list.add(new Chat(input[1], input[0]));
                map.put(input[1], input[2]);
                backup.put(input[1], input[2]);
            }
            else if (input[0].equals("Change")) {
                map.put(input[1], input[2]);
                backup.put(input[1], input[2]);
            }
            else if (input[0].equals("Leave")) {
                list.add(new Chat(input[1], input[0]));
                map.remove(input[1]);
            }
        }


        List<String> result = new ArrayList<>();
        for(Chat c : list) {
            if(c.state.equals("Enter"))
                result.add(backup.get(c.uid) + "님이 들어왔습니다.");
            else result.add(backup.get(c.uid) + "님이 나갔습니다.");
        }

        return answer = result.toArray(new String[result.size()]);
    }
}
