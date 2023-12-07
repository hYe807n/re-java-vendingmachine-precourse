package vendingmachine.controller;

import vendingmachine.view.InputView;

public class MachineController {

    public void run() {
        initializeMachineMoney();
    }

    private void initializeMachineMoney() {
        InputView.readMachineMoney();
    }
}
