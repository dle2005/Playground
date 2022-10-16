package Books.Modern_Java_in_Action;

import java.util.List;

public class PrettyPrintApple {

    /**
     *
     * 각각의 사과 무게를 출력
     * 각각의 사과가 무거운지, 가벼운지
     */
    private static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    private interface AppleFormatter {
        String accept(Apple a);
    }

    private static class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";

        }
    }

    private static class AppleSimplerFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = List.of(
                new Apple(Color.GREEN, 80),
                new Apple(Color.RED, 155)
        );

        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimplerFormatter());
    }

    enum Color { RED, GREEN }

    private static class Apple {
        Color color;
        int weight;

        public Apple(Color color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
