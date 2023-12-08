package vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("투입 금액에 숫자 외의 문자를 입력하면 예외 발생")
    @Test
    void userMoneyNotOnlyNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("a"));
    }
}