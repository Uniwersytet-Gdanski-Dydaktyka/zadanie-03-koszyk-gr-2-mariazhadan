package sort;

import model.Product;
import java.util.Comparator;
import java.util.List;

public class SortByPriceDesc implements ProductSorter {
    public void sort(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }
}