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
}