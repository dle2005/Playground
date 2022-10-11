package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Roman_to_Integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static final Map<String, Integer> romanSymbolMap = new HashMap<>() {
        {
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }
    };

    public static int romanToInt(String s) {
        int answer = 0;

        for (int idx = 0; idx < s.length(); ) {
            String twoChSubStr = s.substring(idx, Math.min(s.length(), idx + 2));
            String oneChSubStr = s.substring(idx, idx + 1);

            if (romanSymbolMap.containsKey(twoChSubStr)) {
                answer += romanSymbolMap.get(twoChSubStr);
                idx += 2;
            } else {
                answer += romanSymbolMap.get(oneChSubStr);
                idx++;
            }
        }

        return answer;
    }
}
