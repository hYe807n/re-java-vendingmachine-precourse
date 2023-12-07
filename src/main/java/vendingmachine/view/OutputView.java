package vendingmachine.view;

import java.text.MessageFormat;
import java.util.StringJoiner;
import vendingmachine.enums.Exception;
import vendingmachine.enums.Form;

public class OutputView {

    public static void printMachineMoneyDemand() {
        System.out.println(Form.MACHINE_MONEY_DEMAND.getMessage());
    }

    public static void printException(String message) {
        System.out.println(
            new StringJoiner("", Exception.ERROR_STARTER.getMessage(), message));
    }

    public static void printCoinsStart() {
        System.out.println(Form.MACHINE_COINS.getMessage());
    }

    public static void printCoin(int coin, int count) {
        System.out.println(MessageFormat.format(Form.MACHINE_COIN.getMessage(), coin, count));
    }

    public static void printProductDemand() {
        System.out.println(Form.MACHINE_PRODUCT_DEMAND.getMessage());
    }

    public static void printUserMoneyDemand() {
        System.out.println(Form.USER_MONEY_DEMAND.getMessage());
    }

    public static void printAmount(int amount) {
        System.out.println(Form.AMOUNT.getMessage());
    }

    public static void printPurchaseDemand() {
        System.out.println(Form.PURCHASE_PRODUCT_DEMAND.getMessage());
    }
}
