package lec11

/**
 * Java에서 유틸성 코드 생성 시에는,
 * abstract class + private constructor 사용해서 인스턴스화, 상속 방지
 *
 * 코틀린에서도 비슷하게 가능하지만,
 * 파일 최상단에 바로 유틸 함수를 작성하면 편리함
 */

fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}