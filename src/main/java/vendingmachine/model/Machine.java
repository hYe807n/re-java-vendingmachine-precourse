package vendingmachine.model;

public class Machine {

    private final int money;

    public Machine(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        Validator.checkOnlyNumber(money);
    }
}
