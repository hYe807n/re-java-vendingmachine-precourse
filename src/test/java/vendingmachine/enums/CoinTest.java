package vendingmachine.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {

    @DisplayName("인자로 받은 500 값이 동전 enum 들의 값 중 같은 개체를 찾아서 500원 개체 반환")
    @Test
    void findByAmount() {
        Assertions.assertEquals(Coin.findByAmount(500), Coin.COIN_500);
    }
}