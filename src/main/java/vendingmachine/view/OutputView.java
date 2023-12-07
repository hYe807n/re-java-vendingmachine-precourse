package vendingmachine.view;

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
}
