package promo;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class FreeCup implements Promotion {
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

        if (sum <= 200) return validProducts;

        List<Product> result = new ArrayList<>(validProducts);
        result.add(new Product("CUP", "Company Cup", 0));
        return result;
    }
}
