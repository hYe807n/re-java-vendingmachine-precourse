package vendingmachine.view;

import vendingmachine.enums.Form;

public class OutputView {

    public static void printMachineMoneyDemand() {
        System.out.println(Form.MACHINE_MONEY_DEMAND.getMessage());
    }
}
