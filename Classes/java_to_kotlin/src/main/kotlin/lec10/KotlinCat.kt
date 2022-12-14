package lec10

/**
 * 코틀린의 상속은 ':'을 한 칸 띄고 사용
 * 상위 클래스 생성자 호출은 상속 표시 옆에 괄호로 바로 호출
 */
class KotlinCat(
    species: String
) : KotlinAnimal(species, 4) {

    /**
     * @override 어노테이션 대신 override 키워드를 사용
     * 반드신 override를 붙여줘야 함
     */
    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~")
    }

}