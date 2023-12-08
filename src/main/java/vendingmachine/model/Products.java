package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.enums.Coin;
import vendingmachine.enums.Exception;

public class Products {

    private static final String PRODUCTS_DIVISION = ";";

    private final List<Product> products;

    public Products(String products) {
        validate(products);
        this.products = Arrays.stream(products.split(PRODUCTS_DIVISION))
            .map(product -> new Product(product.replaceAll("[\\[\\]]", "")))
            .collect(Collectors.toList());
    }

    public Product findByName(String name) {
        return this.products.stream()
            .filter(product -> product.isSameProduct(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Exception.PURCHASE_EXCEPTION.getMessage()));
    }

    public int purchase(int money, String productName) {
        Validator.checkPurchaseState(money, productName, this);
        Product product = findByName(productName);
        return product.calculateAmount(money);
    }

    public boolean isAllSoldOut() {
        return this.products.stream().allMatch(Product::isSoldOut);
    }

    public boolean isLessMinimumPrice(int money) {
        return this.products.stream().allMatch(product -> product.isExpensive(money));
    }

    private void validate(String products) {
        Validator.checkProductsForm(products);
    }


    public boolean checkPurchase(int money) {
        return !(money < Coin.COIN_100.getAmount()
            || isAllSoldOut()
            || isLessMinimumPrice(money));
    }
}
