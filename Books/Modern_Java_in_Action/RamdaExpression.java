package Books.Modern_Java_in_Action;

public class RamdaExpression {
    public static void main(String[] args) {
        /**
         * 람다 표현식
         * ㄴ 익명: 보통의 메서드와 달리 이름이 없으므로 익명이라 표현
         * ㄴ 함수: 람다는 메서드처럼 특정 클래스에 종속되지 않으므로 함수라고 부름
         *         하지만, 메서드처럼 파라미터 리스트, 바디, 반환 형식, 가능한 예외 리스트를 포함
         * ㄴ 전달: 람다 표현식을 메서드 인수로 전달하거나 변수로 지정 가능
         * ㄴ 간결성: 익명 클래스처럼 많은 자질구레한 코드 구현이 필요 없음
         *
         * (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
         * |----람다 파라미터----|화살표|----------람다 바디----------------------|
         * ㄴ 파라미터 리스트: Comparator의 compare 매서드 파라미터
         * ㄴ 화살표(->): 람다의 파라미터 리스트와 바디를 구분
         * ㄴ 람다 바디: 람다의 반환값에 해당하는 표현식
         *
         * 자바 8의 유효한 람다 표현식
         * (String s) -> s.length() String 형식의 파라미터 하나를 가지며 int를 반환
         * (Apple a) -> a.getWeight() Apple 형식의 파라미터 하나를 가지며 boolean을 반환
         * ㄴ 람다 표현식에는 return이 함출되어 있으므로 return 문을 명시적으로 사용하지 않아도 됨
         * (int x, int y) -> {
         *      System.out.println("Result:");
         *      System.out.println(x + y);
         * } int 형식의 파라미터 두 개를 가지며 리턴값이 없음(void 리턴)
         * ㄴ 람다 표현식은 여러 행의 문장을 포함할 수 있음
         * () -> 42 파라미터가 없으며 int 42를 반환
         * (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
         *
         * 잘못된 람다 표현식
         * (Integer i) -> return "Alan" + i;
         * ㄴ return은 흐름 제어문, (Integer -> i) -> {return "Alan" + i;}
         * (String s) -> {"Iron Man";}
         * ㄴ "Iron Man"은 구문이 아니라 표현식, (String s) -> "Iron Man" || (String s) -> {return "Iron Man";}
         */

        // 람다
        Runnable r1 = () -> System.out.println("Hello World 1");

        // 익명 클래스
        @SuppressWarnings("Convert2Lambda")
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World 3"));
    }

    public static void process(Runnable runnable) {
        runnable.run();
    }

}

