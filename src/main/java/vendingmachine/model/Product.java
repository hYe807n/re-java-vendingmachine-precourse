package vendingmachine.model;

public class Product {

    private static final String PRODUCT_DIVISION = ",";
    private static final int INDEX_NAME = 0;
    private static final int INDEX_PRICE = 1;
    private static final int INDEX_COUNT = 2;

    private final String name;
    private final int price;
    private int count;

    public Product(String product) {
        this.name = product.split(PRODUCT_DIVISION)[INDEX_NAME];
        this.price = Integer.parseInt(product.split(PRODUCT_DIVISION)[INDEX_PRICE]);
        this.count = Integer.parseInt(product.split(PRODUCT_DIVISION)[INDEX_COUNT]);
        validate(product.split(PRODUCT_DIVISION)[INDEX_PRICE]);
    }

    public boolean isSoldOut() {
        return this.count == 0;
    }

    public boolean isExpensive(int money) {
        return money < this.price;
    }

    public boolean isSameProduct(String name) {
        return name.equals(this.name);
    }

    private void validate(String price) {
        Validator.checkMoneyRange(price);
        Validator.checkMoneyDivide(price);
    }

    public int calculateAmount(int money) {
        this.count -= 1;
        return money - this.price;
    }
}
