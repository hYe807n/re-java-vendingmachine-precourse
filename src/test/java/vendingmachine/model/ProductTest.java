package vendingmachine.model;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertFalse(new Product("콜라,1000,0").isSoldOut());
    }
}