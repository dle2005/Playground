package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int sum = StringToInt(first) + StringToInt(second);
        String s = IntToString(sum);

        System.out.println(sum);
        System.out.println(s);
    }

    public static String IntToString(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (n >= 1000) {
                n -= 1000;
                sb.append('M');
            } else if (n >= 900) {
                n -= 900;
                sb.append("CM");
            } else if (n >= 500) {
                n -= 500;
                sb.append('D');
            } else if (n >= 400) {
                n -= 400;
                sb.append("CD");
            } else if (n >= 100) {
                n -= 100;
                sb.append('C');
            } else if (n >= 90) {
                n -= 90;
                sb.append("XC");
            } else if (n >= 50) {
                n -= 50;
                sb.append('L');
            } else if (n >= 40) {
                n -= 40;
                sb.append("XL");
            } else if (n >= 10) {
                n -= 10;
                sb.append('X');
            } else if (n >= 9) {
                n -= 9;
                sb.append("IX");
            } else if (n >= 5) {
                n -= 5;
                sb.append('V');
            } else if (n >= 4) {
                n -= 4;
                sb.append("IV");
            } else if (n >= 1) {
                n -= 1;
                sb.append('I');
            }
        }

        return sb.toString();
    }

    public static int StringToInt(String s) {
        int n = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1) {
                switch (s.substring(i, i + 2)) {
                    case "CM" : n += 900; break;
                    case "CD" : n += 400; break;
                    case "XC" : n += 90; break;
                    case "XL" : n += 40; break;
                    case "IX" : n += 9; break;
                    case "IV" : n += 4; break;
                    default : n += CharToInt(s.charAt(i)); i--; break;
                }
                i++;
            } else n += CharToInt(s.charAt(i));
        }

        return n;
    }

    public static int CharToInt(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }
}
