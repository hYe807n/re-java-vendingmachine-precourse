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
}