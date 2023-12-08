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
}