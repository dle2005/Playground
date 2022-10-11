package Baekjoon;

import java.util.Scanner;

public class BOJ_10820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int low = 0, high = 0, num = 0, space = 0;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(Character.isLowerCase(c))
                    low++;
                else if(Character.isUpperCase(c))
                    high++;
                else if('0' <= c && c <= '9')
                    num++;
                else space ++;
            }
            
            System.out.println(low + " " + high + " " + num + " " + space);
        }
    }
}
