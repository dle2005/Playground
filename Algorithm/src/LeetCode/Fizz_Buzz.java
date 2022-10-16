package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();

        for (int idx = 1; idx <= n; idx++) {
            if (idx % 3 == 0 && idx % 5 == 0) {
                output.add("FizzBuzz");
            } else if (idx % 3 == 0) {
                output.add("Fizz");
            } else if (idx % 5 == 0) {
                output.add("Buzz");
            } else {
                output.add(String.valueOf(idx));
            }
        }

        return output;
    }
}
