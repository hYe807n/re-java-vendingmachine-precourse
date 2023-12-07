package vendingmachine.model;

import vendingmachine.enums.Coin;

public class User {

    private int money;

    public User(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public boolean isLessMinimumCoin() {
        return this.money < Coin.COIN_10.getAmount();
    }

    private void validate(String money) {
        Validator.checkOnlyNumber(money);
    }
}
