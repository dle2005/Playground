package lec12;

public class JavaLec12Main {
    public static void main(String[] args) {
        /**
         * KotlinPerson.Companion.newBaby("ABC");
         * 이름이 없는 경우에는 Companion 키워드가 생략된 것
         */

        /**
         * kotlin의 newBaby()에 @JvmStatic 어노테이션을 붙이면 바로 접근 가능
         */
        KotlinPerson.newBaby("ABC");

        /**
         * companion object 이름이 있는 경우, 이름을 통해 접근
         */
        KotlinPerson.Factory.newBaby("ABC");
    }
}
