package promo;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class DiscountOver300 implements Promotion {
    public List<Product> apply(List<Product> products) {
        double sum = 0;
        for (Product p : products) sum += p.getPrice();

        if (sum <= 300) return products;

        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            result.add(new Product(p.getCode(), p.getName(), p.getPrice() * 0.95));
        }
        return result;
    }
}