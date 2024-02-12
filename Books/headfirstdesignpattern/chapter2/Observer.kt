package headfirstdesignpattern.chapter2

interface Observer {
    fun update(temperature: Float, humidity: Float, pressure: Float)
}