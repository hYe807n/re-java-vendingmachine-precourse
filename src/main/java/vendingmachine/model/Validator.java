package vendingmachine.model;

import vendingmachine.enums.Exception;

public class Validator {

    private static final String NUMBER_EXPRESSION = "^[0-9]+$";

    public static void checkOnlyNumber(String money) {
        if (money.matches(NUMBER_EXPRESSION)) {
            return;
        }
        throw new IllegalArgumentException(Exception.NUMBER_EXCEPTION.getMessage());
    }
}
