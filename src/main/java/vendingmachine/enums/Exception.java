package vendingmachine.enums;

public enum Exception {
    ERROR_STARTER("[ERROR] "),
    NUMBER_EXCEPTION("금액은 숫자여야 합니다."),
    MONEY_RANGE_EXCEPTION("금액은 100 원 이상이어야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
