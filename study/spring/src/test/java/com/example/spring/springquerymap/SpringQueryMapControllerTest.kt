package com.example.spring.springquerymap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.LinkedMultiValueMap

@ExtendWith(SpringExtension::class)
@WebMvcTest(SpringQueryMapController::class)
@AutoConfigureMockMvc
class SpringQueryMapControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    companion object {
        const val id = "1"
        const val name = "test"

        val queryParams = LinkedMultiValueMap(mapOf(
            "id" to listOf(id),
            "name" to listOf(name)
        ))

        const val PREFIX = "/spring_query_map"
    }


    @Test
    fun requestParamTest() {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("$PREFIX/request_param")
            .queryParams(queryParams)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        assertEquals("${id} ${name}", result.response.contentAsString)
    }

    @Test
    fun springQueryMapTest() {
        val result = mockMvc.perform(MockMvcRequestBuilders.get("$PREFIX/spring_query_map")
            .queryParams(queryParams)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        assertEquals("${id} ${name}", result.response.contentAsString)
    }
}