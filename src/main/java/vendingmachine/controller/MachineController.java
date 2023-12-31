package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.model.Products;
import vendingmachine.model.User;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private Machine machine;
    private Products products;
    private User user;

    public void run() {
        initializeMachineMoney();
        machineCoins();
        machineProducts();
        userMoney();
        purchaseProduct();
    }

    private void purchaseProduct() {
        int money = this.user.getMoney();
        while (products.checkPurchase(money)) {
            OutputView.printAmount(money);
            money = products.purchase(money, InputView.readPurchaseProduct());
        }
        changeCoins(money);
    }

    private void changeCoins(int money) {
        OutputView.printAmount(money);
        OutputView.printChange();
        machine.calculateChangeCoins(money)
            .forEach((key, value) -> OutputView.printChangeCoin(key.getAmount(), value));
    }

    private void userMoney() {
        try {
            this.user = new User(InputView.readUserMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            userMoney();
        }
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
