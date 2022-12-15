package lec17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaLec17Main {
    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("사과", 1_000),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_500),
                new Fruit("바나나", 3_000),
                new Fruit("바나나", 3_200),
                new Fruit("바나나", 2_500),
                new Fruit("수박", 10_000)
        );

        filterFruits(fruits, new FruitFilter() {
            @Override
            public boolean isSelected(Fruit fruit) {
                return Arrays.asList("사과", "바나나").contains(fruit.getName())
                        && fruit.getPrice() > 5_000;
            }
        });

        filterFruits(fruits, fruit -> Arrays.asList("사과", "바나나").contains(fruit.getName())
                && fruit.getPrice() > 5_000);

        filterFruitsStream(fruits, fruit -> fruit.getName().equals("사과"));
    }

    private static List<Fruit> findApple(List<Fruit> fruits) {
        List<Fruit> apples = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals("사과")) {
                apples.add(fruit);
            }
        }

        return apples;
    }

    private static List<Fruit> findBananas(List<Fruit> fruits) {
        List<Fruit> bananas = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals("바나나")) {
                bananas.add(fruit);
            }
        }

        return bananas;
    }

    private static List<Fruit> findFruitsWithName(List<Fruit> fruits, String name) {
        List<Fruit> results = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals(name)) {
                results.add(fruit);
            }
        }

        return results;
    }

    private static interface FruitFilter {
        boolean isSelected(Fruit fruit);
    }

    private static List<Fruit> filterFruits(List<Fruit> fruits, FruitFilter fruitFilter) {
        List<Fruit> results = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruitFilter.isSelected(fruit)) {
                results.add(fruit);
            }
        }

        return results;
    }

    private static List<Fruit> filterFruitsStream(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }
}
