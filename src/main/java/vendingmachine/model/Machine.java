package vendingmachine.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.enums.Coin;

public class Machine {

    private final int money;
    private final Map<Coin, Integer> coins;

    public Machine(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
        this.coins = initializeRandomCoins();
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    private Map<Coin, Integer> initializeRandomCoins() {
        Map<Coin, Integer> coins = initializeCoins();
        int money = this.money;
        while (money != 0) {
            int coin = Random.pickCoin(coinsToRandom(money));
            money -= coin;
            coins.put(Coin.findByAmount(coin), coins.get(Coin.findByAmount(coin))+1);
        }
        return coins;
    }

    private Map<Coin, Integer> initializeCoins() {
        Map<Coin, Integer> initialCoins = new LinkedHashMap<>();
        for (Coin coin : Coin.values()) {
            initialCoins.put(coin, 0);
        }
        return initialCoins;
    }

    private List<Integer> coinsToRandom(int money) {
        return Arrays.stream(Coin.values())
            .map(Coin::getAmount)
            .filter(amount -> amount <= money)
            .collect(Collectors.toList());
    }

    private void validate(String money) {
        Validator.checkOnlyNumber(money);
        Validator.checkMoneyRange(money);
        Validator.checkMoneyDivide(money);
    }


}
