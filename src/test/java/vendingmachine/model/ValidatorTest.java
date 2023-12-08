package vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("입력받은 금액이 숫자 외의 문자가 포함되었다면 예외 발생")
    @Test
    void checkOnlyNumber() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.checkOnlyNumber("a"));
    }

    @DisplayName("입력받은 상품명, 가격, 개수 양식이 다르다면 예외 발생")
    @Test
    void checkProductsForm() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.checkProductsForm("[콜라=200=1]"));
    }

    @DisplayName("입력받은 금액이 100 원 미만이라면 예외 발생")
    @Test
    void checkMoneyRange() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.checkMoneyRange("90"));
    }

    @DisplayName("입력받은 금액이 10 원 단위가 아니라면 예외 발생")
    @Test
    void checkMoneyDivide() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.checkMoneyDivide("91"));
    }

    @DisplayName("구매할 상품이 품절이라면 예외 발생")
    @Test
    void checkPurchaseStateSoldOut() {
        Products products = new Products("[콜라,2000,0]");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.checkPurchaseState(3000, "콜라", products));
    }

    @DisplayName("구매할 상품이 투입 금액보다 비싸다면 예외 발생")
    @Test
    void checkPurchaseStateExpensive() {
        Products products = new Products("[콜라,5000,1]");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.checkPurchaseState(3000, "콜라", products));
    }
}