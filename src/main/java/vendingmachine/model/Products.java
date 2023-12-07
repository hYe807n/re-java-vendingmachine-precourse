package vendingmachine.model;

import java.util.Arrays;
import java.util.List;

public class Products {

    private static final String PRODUCTS_DIVISION = ";";

    private List<Product> products;

    public Products(String products) {
        validate(products);
        Arrays.stream(products.split(PRODUCTS_DIVISION))
            .forEach(product -> new Product(product.replace("[]", "")));
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
