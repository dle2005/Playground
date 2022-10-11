package LeetCode;

import java.util.Arrays;

public class Reverse_Words_in_a_String_III {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("God Ding"));
    }

    public static String reverseWords(String s) {
        StringBuilder output = new StringBuilder();

        Arrays.stream(s.split(" ")).forEach(subStr -> {
            output.append(reverseString(subStr)).append(" ");
        });

        output.setLength(output.length() - 1);
        return output.toString();
    }

    public static String reverseString(String s) {
        StringBuilder temp = new StringBuilder();

        for (char c : s.toCharArray()) {
            temp.insert(0, c);
        }

        return temp.toString();
    }
}
