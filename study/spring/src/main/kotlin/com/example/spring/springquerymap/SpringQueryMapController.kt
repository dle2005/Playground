package com.example.spring.springquerymap

import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spring_query_map")
class SpringQueryMapController {

    @GetMapping("/request_param")
    fun requestParam(
        @RequestParam("id") id: Int,
        @RequestParam("name") name: String,
    ) : String {
        return "${id} ${name}"
    }

    @GetMapping("/spring_query_map")
    fun springQueryMap(
        @SpringQueryMap queryParams: MyQueryParam,
    ) : String {
        return "${queryParams.id} ${queryParams.name}"
    }
}