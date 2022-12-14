package lec13;

public class JavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    /**
     * 내부에서 외부 클래스를 참조할 수 있는 문제가 있음
     *
     * 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우
     * 메모리 누수가 생길 수 있으며, 이를 디버깅 하기 어려움
     *
     * 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한
     *
     * 클래스 안에 클래스를 만들 때는 static 클래스를 사용하라
     */
    public class LivingRoom {
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }

        public String getAddress() {
            // 내부에서 외부 클래스의 변수를 가져와 사용 가능
            return JavaHouse.this.address;
        }
    }
}
