package com.example.superbuilder;

import com.example.spring.superbuilder.Child;
import org.junit.jupiter.api.Test;

class SupperBuilderTest {

    @Test
    void supperBuilderTest() {
        Child child = Child.builder()
                .parentField("parent")
                .childField("child")
                .build();
    }

}