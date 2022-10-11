package programmers;

import java.util.Arrays;

public class P_12917_v2 {

    class Solution {
        public String solution(String s) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder(String.valueOf(arr));

            return sb.reverse().toString();
        }
    }
}
