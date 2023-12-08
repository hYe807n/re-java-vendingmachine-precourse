package vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductsTest {

    @DisplayName("상품명, 가격, 개수 양식이 다르다면 예외 발생")
    @Test
    void formOfProducts() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Products("[콜라-1000-1];[사이다,1500,2]"));
    }
}