package headfirstdesignpattern.chapter2

data class CurrentConditionsDisplay(
    val weatherData: WeatherData,
    var temperature: Float = 0.0f,
    var humidity: Float  = 0.0f,
): Observer, DisplayElement {
    init {
        weatherData.registerObserver(this)
    }

    override fun display() {
        println("현재 상태: 온도 ${temperature}F, 습도 ${humidity}%")
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }
}