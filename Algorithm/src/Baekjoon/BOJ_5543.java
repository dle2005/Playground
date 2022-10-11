package Baekjoon;

import java.util.Scanner;

public class BOJ_5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int burger = 0, drink = 0;
        int min_burger = 2000, min_drink = 2000;
        
        for(int i = 0; i < 3; i++) {
            burger = sc.nextInt();
            if(burger < min_burger) min_burger = burger;
        }
        for(int i = 0; i < 2; i++) {
            drink = sc.nextInt();
            if(drink < min_drink) min_drink = drink;
        }

        System.out.println(min_burger + min_drink - 50);
        
        sc.close();
    }
}
