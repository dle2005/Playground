package IO_files;

import java.io.File;

public class FolderNameChange {
    public static void main(String[] args) {
        String path = "/Users/dlee/Desktop/Algorithm_Study/backjoon/";
        File dir = new File(path);

        File[] files = dir.listFiles();

        for (File file : files) {
            System.out.println(file.getName());
            File newFile = new File(path + "BOJ_" + file.getName());
            file.renameTo(newFile);
        }
    }
}