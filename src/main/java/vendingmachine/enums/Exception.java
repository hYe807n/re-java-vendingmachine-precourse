package vendingmachine.enums;

public enum Exception {
    ERROR_STARTER("[ERROR] "),
    NUMBER_EXCEPTION("금액은 숫자여야 합니다."),
    PURCHASE_EXCEPTION("구매할 수 없습니다."),
    PRODUCTS_EXCEPTION("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 합니다."),
    MONEY_DIVIDE_EXCEPTION("금액은 10 원 단위여야 합니다."),
    COINS_EXCEPTION("없는 동전입니다."),
    MONEY_RANGE_EXCEPTION("금액은 100 원 이상여야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
