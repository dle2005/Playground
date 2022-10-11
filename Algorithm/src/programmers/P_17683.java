package programmers;

public class P_17683 {
    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
    public static String solution(String m, String[] musicinfos) {
        String answer = "None";

        m = deleteHash(m);

        int max_length = 0;

        String[][] music = new String[musicinfos.length][4];
        for (int i = 0; i < musicinfos.length; i++) {
            music[i] = musicinfos[i].split(",");

            int s_hour = Integer.parseInt(music[i][0].substring(0, 2));
            int e_hour = Integer.parseInt(music[i][1].substring(0, 2));
            int s_min = Integer.parseInt(music[i][0].substring(3, 5));
            int e_min = Integer.parseInt(music[i][1].substring(3, 5));
            int time = (e_hour - s_hour) * 60 + e_min - s_min;

            music[i][3] = deleteHash(music[i][3]);

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < time; j++)
                sb.append(music[i][3].charAt(j % music[i][3].length()));
            music[i][3] = sb.toString();

            if (KMP(music[i][3], m) && max_length < time) {
                max_length = time;
                answer = music[i][2];
            }
        }

        return answer;
    }

    public static boolean KMP(String s, String p) {
        int[] pi = getPi(p);

        for (int i = 0, j = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != p.charAt(j))
                j = pi[j - 1];

            if (s.charAt(i) == p.charAt(j)) {
                if(j == p.length() - 1)
                    return true;
                else j++;
            }
        }

        return false;
    }

    public static int[] getPi(String m) {
        int[] pi = new int[m.length()];

        for (int i = 1, j = 0; i < m.length(); i++) {
            while(j > 0 && m.charAt(i) != m.charAt(j))
                j = pi[j - 1];

            if(m.charAt(i) == m.charAt(j))
                pi[i] = ++j;
        }

        return pi;
    }

    public static String deleteHash(String s) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            if (j != s.length() - 1 && s.charAt(j + 1) == '#') {
                sb.append(Character.toLowerCase(s.charAt(j)));
                j++;
            }
            else sb.append(s.charAt(j));
        }

        return sb.toString();
    }
}
