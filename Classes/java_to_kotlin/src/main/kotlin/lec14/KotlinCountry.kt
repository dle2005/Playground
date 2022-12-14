package lec14

fun handleCountry(country: KotlinCountry) {
    when (country) {
        KotlinCountry.KOREA -> TODO()
        KotlinCountry.AMERICA -> TODO()
    }
}

enum class KotlinCountry(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US");
}