package vendingmachine.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.List;

public class Random {
    public static int pickCoin(List<Integer> coins) {
        return pickNumberInList(coins);
    }
}
