package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    public void run() {
        initializeMachineMoney();
    }

    private void initializeMachineMoney() {
        try {
            new Machine(InputView.readMachineMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            initializeMachineMoney();
        }
    }
}
