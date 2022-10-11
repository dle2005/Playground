package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Integer_to_Roman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

        assert intToRoman(3).equals("III");
        assert intToRoman(58).equals("LVIII");
        assert intToRoman(1994).equals("MCMXCIV");
    }

    static private final Map<Integer, String> romanSymbolMap = new LinkedHashMap<>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };

    public static String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanSymbolMap.entrySet()) {
            if (num / entry.getKey() != 0) {
                answer.append(entry.getValue().repeat(num / entry.getKey()));
                num -= entry.getKey() * (num / entry.getKey());
            }
        }

        return answer.toString();
    }
}
