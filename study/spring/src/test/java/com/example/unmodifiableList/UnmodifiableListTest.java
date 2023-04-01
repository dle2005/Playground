package com.example.unmodifiableList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class UnmodifiableListTest {

    @Test
    void unmodifiableListTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toUnmodifiableList());

        Assertions.assertThrows(UnsupportedOperationException.class, () -> evenNumbers.add(6));
        Assertions.assertEquals(Arrays.asList(2, 4), evenNumbers);
    }
}
