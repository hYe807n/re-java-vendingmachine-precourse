package vendingmachine.enums;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin findByAmount(int amount) {
        return Arrays.stream(Coin.values())
            .filter(coin -> coin.getAmount() == amount)
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException(Exception.COINS_EXCEPTION.getMessage()));
    }
}
