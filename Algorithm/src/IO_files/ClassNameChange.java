package IO_files;

import java.io.*;

public class ClassNameChange {
    public static void main(String[] args) throws IOException {
        String path = "/Users/dlee/Desktop/Algorithm_Study/backjoon/";
        File dir = new File(path);

        File[] files = dir.listFiles();

        for (File file : files) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String str;

            FileWriter t = new FileWriter(file);
            char[] temp = new char[10];
            t.write(temp);
            t.close();

            while ((str = br.readLine()) != null) {
                if (str.contains("Main")) {
                    String name = file.getName().substring(0, file.getName().length() - 5);
                    str = str.replaceAll("Main", name);
                }

                sb.append(str).append("\n");
            }
            System.out.print(sb);
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(sb.toString(), 0, sb.length());
            bw.flush();
            bw.close();
        }
    }
}
