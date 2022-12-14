package lec16;

public class JavaPerson {

    private final String firstName;
    private final String lastName;
    private int age;

    public JavaPerson(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int nextYearAge() {
        System.out.println("맴버 함수");
        return this.age + 1;
    }
}
