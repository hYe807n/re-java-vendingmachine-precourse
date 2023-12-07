package vendingmachine.model;

import java.util.Arrays;
import java.util.List;

public class Products {

    private static final String PRODUCTS_DIVISION = ";";
    private static final String PRODUCT_DIVISION = ",";
    private static final int INDEX_NAME = 0;
    private static final int INDEX_PRICE = 1;
    private static final int INDEX_COUNT = 2;

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
