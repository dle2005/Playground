package Algorithm;

public class KMP {
    public static int kmp(String S, String K) {
        int answer = 0;
        int[] pattern = getPattern(K);

        for (int i = 0, j = 0; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != K.charAt(j))
                j = pattern[j - 1];

            if (S.charAt(i) == K.charAt(j)) {
                if (j == K.length() - 1) {
                    answer = 1;
                    break;
                } else j++;
            }
        }
        return answer;
    }

    public static int[] getPattern(String P) {
        int[] pattern = new int[P.length()];

        for (int i = 1, j = 0; i < P.length(); i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j))
                j = pattern[j - 1];

            if(P.charAt(i) == P.charAt(j))
                pattern[i] = ++j;
        }

        return pattern;
    }
}

