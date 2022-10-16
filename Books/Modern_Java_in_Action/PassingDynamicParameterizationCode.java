package Books.Modern_Java_in_Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Books.Modern_Java_in_Action.PassingDynamicParameterizationCode.Color.GREEN;
import static Books.Modern_Java_in_Action.PassingDynamicParameterizationCode.Color.RED;

public class PassingDynamicParameterizationCode {

    enum Color { RED, GREEN }

    /**
     * 2.1.1 첫 번째 시도 : 녹색 사과 필터링
     *
     * 다양한 색으로 필터링하는 등의 변화에는 적절하게 대응할 수 없음.
     */
    @SuppressWarnings("unused")
    private static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 2.1.2 두 번째 시도 : 색을 파라미터화
     *
     * 색 이외의 다른 요구사항에는 적절하게 대응할 수 없음
     */
    @SuppressWarnings("unused")
    private static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 2.1.3 세 번째 시도 : 가능한 모든 속성으로 필터링
     *
     * flag의 의미가 명확하지 않음
     * 요구사항 변화에 유연하게 대응할 수 없음
     */
    @SuppressWarnings("unused")
    private static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 동작 파라미터화
     *
     * 선택 조건을 결정하는 인터페이스를 정의 (전략 디자인 패턴)
     */
    private interface ApplePredicate {
        boolean test(Apple apple);
    }

    private static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    private static class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return GREEN.equals(apple.getColor());
        }
    }

    /**
     * 2.2.1 네 번째 시도 : 추상적 조건으로 필터링
     *
     * Predicate 객체로 사과 검사 조건을 캡슐화
     * 전달한 ApplePredicate 객체에 의해 filterApples 매서드의 동작이 결정
     */
    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    @SuppressWarnings({"unused", "DanglingJavadoc"})
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        /**
         * 2.3.2 다섯 번째 시도 : 익명 클래스 사용
         *
         * 불필요한 많은 공간을 차지함
         */
        //noinspection Convert2Lambda
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        /**
         * 2.3.3 여섯 번째 시도 : 람도 표현식 사용
         *
         * 익명 클래스의 불필요한 공간을 제거 복잡성 문제를 해결
         */
        List<Apple> result = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));
    }

    /**
     * 2.3.4 일곱 번째 시도 : 리스트 형식으로 추상화
     */
    public interface Predicate<T> {
        boolean test(T t);
    }

    @SuppressWarnings("unused")
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }


    private static class Apple {
        int weight;
        Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        @SuppressWarnings("unused")
        public void setColor(Color color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        @SuppressWarnings("unused")
        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
