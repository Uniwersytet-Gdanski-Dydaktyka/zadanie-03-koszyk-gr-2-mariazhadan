package promo;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class FreeCup implements Promotion {
    public List<Product> apply(List<Product> products) {
        double sum = 0;
        for (Product p : products) sum += p.getPrice();

        if (sum <= 200) return products;

        List<Product> result = new ArrayList<>(products);
        result.add(new Product("CUP", "Company Cup", 0));
        return result;
    }
}