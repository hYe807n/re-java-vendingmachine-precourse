package vendingmachine.model;


public class User {

    private int money;

    public User(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    private void validate(String money) {
        Validator.checkOnlyNumber(money);
    }
}
