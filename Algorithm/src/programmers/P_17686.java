package programmers;

import java.util.Arrays;

public class P_17686 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
        System.out.println(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}));
    }
    public static class File implements Comparable<File>{
        String head;
        String num;
        String tail;

        public File(String head, String num, String tail) {
            this.head = head;
            this.num = num;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.toLowerCase().equals(o.head.toLowerCase())) {
                if(this.num == o.num)
                    return 1;
                else return Integer.parseInt(this.num) - Integer.parseInt(o.num);
            }
            else return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }

        @Override
        public String toString() {
            return head+num+tail;
        }
    }


    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        File[] file_name = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            int index = 0;

            for (int j = 0; j < files[i].length(); j++) {
                if(Character.isDigit(files[i].charAt(j))) break;

                head.append(files[i].charAt(j));
                index++;
            }

            for (int j = index; j < files[i].length(); j++) {
                if(!Character.isDigit(files[i].charAt(j))) break;

                number.append(files[i].charAt(j));
                index++;
            }

            file_name[i] = new File(head.toString(),
                    number.toString(), files[i].substring(index));

        }

        Arrays.sort(file_name);

        for(int i = 0; i < files.length; i++)
            answer[i] = file_name[i].toString();

        return answer;
    }
}
