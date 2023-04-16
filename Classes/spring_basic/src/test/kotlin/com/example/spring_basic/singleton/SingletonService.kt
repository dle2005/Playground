package com.example.spring_basic.singleton

class SingletonService private constructor(){
    companion object {
        private val instance = SingletonService()

        fun getInstance(): SingletonService {
            return instance
        }
    }

    fun logic() {
        println("싱글톤 객체 로직 호출")
    }
}