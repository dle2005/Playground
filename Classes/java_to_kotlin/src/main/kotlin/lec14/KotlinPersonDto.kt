package lec14

/**
 * 앞에 data 키워드를 붙이면 자동으로 equals, hashcode, toString을 생성
 * named argument까지 활용하면 builder pattern을 쓰는 것 같은 효과도 있음
 */
data class KotlinPersonDto(
    val name: String,
    val age: Int
)