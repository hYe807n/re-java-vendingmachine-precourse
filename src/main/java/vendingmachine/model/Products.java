package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import vendingmachine.enums.Exception;

public class Products {

    private static final String PRODUCTS_DIVISION = ";";

    private List<Product> products;

    public Products(String products) {
        validate(products);
        Arrays.stream(products.split(PRODUCTS_DIVISION))
            .forEach(product -> new Product(product.replace("[]", "")));
    }

    public Product findByName(String name) {
        return this.products.stream()
            .filter(product -> product.isSameProduct(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Exception.PURCHASE_EXCEPTION.getMessage()));
    }

    public void purchase(int money, String productName) {
        Validator.checkPurchaseState(money, productName, this);
    }

    public boolean isAllSoldOut() {
        return this.products.stream().allMatch(product -> product.getCount() == 0);
    }

    public boolean isLessMinimumPrice(int money) {
        return money < this.products.stream().mapToInt(Product::getPrice).max().getAsInt();
    }

    private void validate(String products) {
        Validator.checkProductsForm(products);
    }
}
