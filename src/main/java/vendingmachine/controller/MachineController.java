package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private Machine machine;

    public void run() {
        initializeMachineMoney();
        machineCoins();
        machineProducts();
    }

    private void machineProducts() {
        InputView.readMachineProduct();
    }

    private void machineCoins() {
        OutputView.printCoinsStart();
        machine.getCoins()
            .forEach((coin, count) -> OutputView.printCoin(coin.getAmount(), count));
    }

    private void initializeMachineMoney() {
        try {
            this.machine = new Machine(InputView.readMachineMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            initializeMachineMoney();
        }
    }
}
