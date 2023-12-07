package vendingmachine.model;

import vendingmachine.enums.Exception;

public class Validator {

    private static final String NUMBER_EXPRESSION = "^[0-9]+$";
    private static final int MINIMUM_MONEY = 100;

    public static void checkOnlyNumber(String money) {
        if (money.matches(NUMBER_EXPRESSION)) {
            return;
        }
        throw new IllegalArgumentException(Exception.NUMBER_EXCEPTION.getMessage());
    }

    public static void checkMoneyRange(String money) {
        if (Integer.parseInt(money) < MINIMUM_MONEY) {
            throw new IllegalArgumentException(Exception.MONEY_RANGE_EXCEPTION.getMessage());
        }
    }
}
