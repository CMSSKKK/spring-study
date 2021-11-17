package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드
    // 스프링 빈은 꼭 무상태(stateless)로 설계해야한다.
    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);

        this.price = price; // 여기가 문제 !
    }
    public int orderStateless(String name, int price) {
        System.out.println("name = " + name + " price = " + price);

        return price;
    }
    public int getPrice() {
        return price;
    }

}
