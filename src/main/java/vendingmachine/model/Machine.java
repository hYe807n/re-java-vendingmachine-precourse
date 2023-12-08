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
            coins.put(Coin.findByAmount(coin), coins.get(Coin.findByAmount(coin)) + 1);
        }
        return coins;
    }

    public Map<Coin, Integer> calculateChangeCoins(int money) {
        Map<Coin, Integer> changeCoins = initializeCoins();
        while (money >= Coin.COIN_10.getAmount()
            && coins.values().stream().anyMatch(count -> count != 0)) {
            Coin coin = Coin.findByAmount(findMaxCoin(money));
            changeCoins.put(coin, changeCoins.get(coin) + 1);
            coins.put(coin, coins.get(coin) - 1);
            money -= coin.getAmount();
        }
        return removeZeroValue(changeCoins);
    }

    private Map<Coin, Integer> removeZeroValue(Map<Coin, Integer> coins) {
        return coins.entrySet().stream()
            .filter(coin -> coin.getValue() > 0)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (existing, replacement) -> existing, LinkedHashMap::new));
    }

    private int findMaxCoin(int money) {
        return Arrays.stream(Coin.values())
            .filter(coin -> coin.getAmount() <= money && coins.get(coin) > 0)
            .mapToInt(Coin::getAmount)
            .max().getAsInt();
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
