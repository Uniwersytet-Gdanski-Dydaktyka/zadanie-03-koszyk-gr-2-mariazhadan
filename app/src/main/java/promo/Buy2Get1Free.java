package promo;

import model.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Buy2Get1Free implements Promotion {
    public List<Product> apply(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparingDouble(Product::getPrice).reversed());

        List<Product> result = new ArrayList<>();
        int count = 0;

        for (Product p : sorted) {
            count++;
            if (count == 3) {
                result.add(new Product(p.getCode(), p.getName(), 0));
                count = 0;
            } else {
                result.add(p);
            }
        }
        return result;
    }
}