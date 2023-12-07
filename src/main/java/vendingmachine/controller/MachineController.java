package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.model.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private Machine machine;
    private Products products;

    public void run() {
        initializeMachineMoney();
        machineCoins();
        machineProducts();
        userCoins();
    }

    private void userCoins() {
        InputView.readUserMoney();
    }

    private void machineProducts() {
        try {
            this.products = new Products(InputView.readMachineProduct());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            machineProducts();
        }
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
