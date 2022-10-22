package Books.Modern_Java_in_Action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RunAroundPattern {

    /**
     * 실행 어라운드 패턴
     * 중복되는 준비 코드와 정리 코드가 작업을 감싸고 있음
     * 초기화/준비 코드 - 작업 - 정리/마무리 코드
     */
    @SuppressWarnings("unused")
    public static String processFile() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    /**
     * 함수형 인터페이스를 이용해서 동작을 전달
     * 한 번에 두 행을 읽는 등 작업 과정을 유연하게 동작
     */
    public static void main(String[] args) throws IOException {
        @SuppressWarnings({"Convert2MethodRef", "unused"})
        String oneLine = processFile((BufferedReader br) -> br.readLine());

        @SuppressWarnings("unused")
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }
}
