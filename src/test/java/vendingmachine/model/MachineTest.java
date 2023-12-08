package vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MachineTest {

    @DisplayName("랜덤하게 뽑힌 자판기 동전들의 합계가 투입 금액과 같은지 확인")
    @Test
    void checkSumCoins() {
        int money = new Machine("500").getCoins().entrySet()
                .stream().mapToInt(coin -> coin.getValue() * coin.getKey().getAmount()).sum();
        Assertions.assertEquals(500, money);
    }
}