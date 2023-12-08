package vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

    @DisplayName("상품 가격이 100 원 미만이라면 예외 발생")
    @Test
    void lessPrice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("콜라,10,1"));
    }

    @DisplayName("상품 가격이 10 원으로 나누어떨어지지 않으면 예외 발생")
    @Test
    void dividePrice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Product("콜라,11111,1"));
    }

    @DisplayName("상품 개수가 0 개라면 품절 상태 true 반환")
    @Test
    void isSoldOut() {
        Assertions.assertTrue(new Product("콜라,1000,0").isSoldOut());
    }

    @DisplayName("제품 가격 1000원이 현재 돈 500 원보다 비싸면 true 반환")
    @Test
    void isExpensive() {
        Assertions.assertTrue(new Product("콜라,1000,1").isExpensive(500));
    }

    @DisplayName("제품 이름\"콜라\"가 현재 제품 이름과 같다면 true 반환")
    @Test
    void isSameProduct() {
        Assertions.assertTrue(new Product("콜라,1000,1").isSameProduct("콜라"));
    }

    @DisplayName("금액 - 제품 가격 계산 결과 500 원을 반환")
    @Test
    void calculateAmount() {
        Assertions.assertEquals(new Product("콜라,500,1").calculateAmount(1000), 500);
    }
}