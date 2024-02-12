package headfirstdesignpattern.chapter2

class WeatherData(
    private val observers: List<Observer> = listOf(),
    private var temperature: Float = 0.0f,
    private var humidity: Float = 0.0f,
    private var pressure: Float = 0.0f,
): Subject {
    override fun registerObserver(o: Observer) {
        observers.plus(o)
    }

    override fun removeObserver(o: Observer) {
        observers.minus(o)
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update(temperature, humidity, pressure)
        }
    }

    private fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}