package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_17677 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands\t"));
        System.out.println(solution("aa1+aa2\t", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
    public static int solution(String str1, String str2) {
        int answer = 0;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1)))
                list1.add((Character.toUpperCase(str1.charAt(i)) + "" + Character.toUpperCase(str1.charAt(i + 1))));
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1)))
                list2.add((Character.toUpperCase(str2.charAt(i)) + "" + Character.toUpperCase(str2.charAt(i + 1))));
        }

        int inter = 0;
        int union = 0;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    list1.remove(i); i--;
                    list2.remove(j);
                    inter++;
                    break;
                }
            }
        }

        union = inter + list1.size() + list2.size();

        if(union != 0) return answer = 65536 * inter / union;
        else return 65536;
    }
}
