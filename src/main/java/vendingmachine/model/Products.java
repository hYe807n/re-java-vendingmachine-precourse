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


    private void validate(String products) {
        Validator.checkProductsForm(products);
    }


}
