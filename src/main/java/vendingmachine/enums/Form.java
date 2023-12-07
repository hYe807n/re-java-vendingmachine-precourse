package vendingmachine.enums;

public enum Form {
    MACHINE_MONEY_DEMAND("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_PRODUCT_DEMAND("상품명과 가격, 수량을 입력해 주세요."),
    USER_MONEY_DEMAND("투입 금액을 입력해 주세요."),
    MACHINE_COIN("{0}원 - {1}개"),
    MACHINE_COINS("\n자판기가 보유한 동전");

    private final String message;

    Form(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
