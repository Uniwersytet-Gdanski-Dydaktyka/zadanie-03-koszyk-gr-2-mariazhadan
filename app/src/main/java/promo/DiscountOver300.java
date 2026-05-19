package promo;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class DiscountOver300 implements Promotion {
    public List<Product> apply(List<Product> products) {
        List<Product> validProducts = new ArrayList<>();
        if (products == null) return validProducts;

        double sum = 0;
        for (Product p : products) {
            if (p != null) {
                validProducts.add(p);
                sum += p.getPrice();
            }
        }

        if (sum <= 300) return validProducts;

        List<Product> result = new ArrayList<>();
        for (Product p : validProducts) {
            result.add(new Product(p.getCode(), p.getName(), p.getPrice() * 0.95));
        }
        return result;
    }
}
