package programmers;

import java.util.Arrays;
import java.util.Collections;

public class P_12933_v2 {
    class Solution {
        public long solution(long n) {
            String[] arr = String.valueOf(n).split(""); // 1
            Arrays.sort(arr, Collections.reverseOrder()); // 2

            StringBuilder sb = new StringBuilder(); // 3
            for (String s : arr) {
                sb.append(s);
            }

            return Long.parseLong(sb.toString()); //
        }
    }
}
