package vendingmachine.model;

import vendingmachine.enums.Coin;
import vendingmachine.enums.Exception;

public class Validator {

    private static final String NUMBER_EXPRESSION = "^[0-9]+$";
    private static final String PRODUCTS_EXPRESSION = "^(\\[[가-힣]+,[0-9]+,[0-9]+\\])+(;\\[[가-힣]+,[0-9]+,[0-9]+\\])*$";

    public static void checkOnlyNumber(String money) {
        if (money.matches(NUMBER_EXPRESSION)) {
            return;
        }
        throw new IllegalArgumentException(Exception.NUMBER_EXCEPTION.getMessage());
    }

    public static void checkPurchaseState(int money, String productName, Products products) {
        if (products.findByName(productName).isSoldOut()
            || products.findByName(productName).isExpensive(money)) {
            throw new IllegalArgumentException(Exception.PURCHASE_EXCEPTION.getMessage());
        }
    }

    public static void checkProductsForm(String products) {
        if (products.matches(PRODUCTS_EXPRESSION)) {
            return;
        }
        throw new IllegalArgumentException(Exception.PRODUCTS_EXCEPTION.getMessage());
    }

    public static void checkMoneyRange(String money) {
        if (Integer.parseInt(money) < Coin.COIN_100.getAmount()) {
            throw new IllegalArgumentException(Exception.MONEY_RANGE_EXCEPTION.getMessage());
        }
    }

    public static void checkMoneyDivide(String money) {
        if (Integer.parseInt(money) % Coin.COIN_50.getAmount() != 0) {
            throw new IllegalArgumentException(Exception.MONEY_DIVIDE_EXCEPTION.getMessage());
        }
    }
}
