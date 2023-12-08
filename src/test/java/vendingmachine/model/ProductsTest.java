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

    @DisplayName("투입 금액 500 원이 모든 상품 가격보다 낮다면 true 반환")
    @Test
    void isLessMinimumPrice() {
        Assertions.assertTrue(new Products("[콜라,1000,1];[사이다,1500,2]").isLessMinimumPrice(100));
    }

    @DisplayName("모든 상품의 개수가 0 개 라면 true 반환")
    @Test
    void isAllSoldOut() {
        Assertions.assertTrue(new Products("[콜라,1000,0];[사이다,1500,0]").isAllSoldOut());
    }

    @DisplayName("\"콜라\" 제품 이름을 통해 콜라 product를 반환")
    @Test
    void findByName() {
        Assertions.assertTrue(new Products("[콜라,1000,1];[사이다,1500,2]")
            .findByName("콜라").isSameProduct("콜라"));

    }

    @DisplayName("없는 제품 \"복숭아\" 이름을 찾았다면 예외 발생")
    @Test
    void findByNameNoneExist() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Products("[콜라,1000,1];[사이다,1500,2]").findByName("복숭아"));
    }

    @DisplayName("투입 금액이 상품 가격 100 원 최소값보다 적다면 제품 구매 상태 false 반환")
    @Test
    void checkPurchaseNotAllowed() {
        Assertions.assertFalse(new Products("[콜라,1000,1];[사이다,1500,2]").checkPurchase(10));
    }
}