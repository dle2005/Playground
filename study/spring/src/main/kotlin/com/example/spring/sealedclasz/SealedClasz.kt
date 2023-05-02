package com.example.spring.sealedclasz
sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Square(val side: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
}

fun calculateArea(shape: Shape): Double {
    return when (shape) {
        is Shape.Circle -> 3.14 * shape.radius * shape.radius
        is Shape.Square -> shape.side * shape.side
        is Shape.Rectangle -> shape.width * shape.height
    }
}

fun main() {
    println(calculateArea(Shape.Circle(3.14)))
    println(calculateArea(Shape.Square(3.0)))
    println(calculateArea(Shape.Rectangle(3.0, 4.0)))
}