package lec15;

import java.util.Arrays;
import java.util.List;

public class JavaLec15Main {
    public static void main(String[] args) {
        int[] array = {100, 200};

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s %s", i, array[i]);
        }

        final List<Integer> numbers = Arrays.asList(100, 200);
    }
}
