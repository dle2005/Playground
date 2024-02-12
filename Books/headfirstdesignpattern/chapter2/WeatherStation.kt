package headfirstdesignpattern.chapter2

fun main() {
    val weatherData = WeatherData()

    CurrentConditionsDisplay(weatherData)

    weatherData.setMeasurements(80f, 65f, 30.4f)
}
