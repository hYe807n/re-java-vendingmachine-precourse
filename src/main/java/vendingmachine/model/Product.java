package vendingmachine.model;

public class Product {

    private static final String PRODUCT_DIVISION = ",";
    private static final int INDEX_NAME = 0;
    private static final int INDEX_PRICE = 1;
    private static final int INDEX_COUNT = 2;

    private final String name;
    private final String price;
    private final String count;

    public Product(String product) {
        this.name = product.split(PRODUCT_DIVISION)[INDEX_NAME];
        this.price = product.split(PRODUCT_DIVISION)[INDEX_PRICE];
        this.count = product.split(PRODUCT_DIVISION)[INDEX_COUNT];
        validate(this.price);
    }

    private void validate(String price) {
        Validator.checkMoneyRange(price);
    }
}
