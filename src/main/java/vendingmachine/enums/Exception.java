package vendingmachine.enums;

public enum Exception {
    ERROR_STARTER("[ERROR] "),
    NUMBER_EXCEPTION("금액은 숫자여야 합니다."),
    MONEY_DIVIDE_EXCEPTION("금액은 10 원 단위여야 합니다."),
    MONEY_RANGE_EXCEPTION("금액은 100 원 이상여야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
