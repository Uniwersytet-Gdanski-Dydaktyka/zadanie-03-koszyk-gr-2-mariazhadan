package promo;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class Coupon30Percent implements Promotion {

    private final String productCode;

    public Coupon30Percent(String productCode) {
        this.productCode = productCode;
    }

    public List<Product> apply(List<Product> products) {
        List<Product> result = new ArrayList<>();
        if (products == null) return result;

        for (Product p : products) {
            if (p == null) continue;

            if (p.getCode().equals(productCode)) {
                result.add(new Product(p.getCode(), p.getName(), p.getPrice() * 0.7));
            } else {
                result.add(p);
            }
        }
        return result;
    }
}
