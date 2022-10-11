package LeetCode;

import java.util.Arrays;

public class Reverse_String {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(new String(s).chars().mapToObj(i -> (char)i).toArray()));
    }

    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        while (l <= r) {
            swap(s, l++, r--);
        }
    }

    public static void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
