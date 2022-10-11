package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        combine(4, 2).forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });

        combine(1, 1).forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();

        if (n < k || k == 0) {
            return output;
        }

        output = combine(n - 1, k - 1);

        if (output.isEmpty()) {
            output.add(new ArrayList<>());
        }

        for (List<Integer> list : output) {
            list.add(n);
        }

        output.addAll(combine(n - 1, k));

        return output;
    }
}
