package com.example.spring_core_advanced.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void requestTest() {
        String result = this.restTemplate.getForObject("/v5/request?itemId=hello", String.class);

        assertThat(result).isEqualTo("ok");
    }

}