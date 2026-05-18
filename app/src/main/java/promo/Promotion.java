package promo;

import model.Product;
import java.util.List;

public interface Promotion {
    List<Product> apply(List<Product> products);
}