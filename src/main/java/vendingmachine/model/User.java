package vendingmachine.model;

import vendingmachine.view.InputView;

public class User {

    private int money;

    public User(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        Validator.checkOnlyNumber(money);
    }
}
