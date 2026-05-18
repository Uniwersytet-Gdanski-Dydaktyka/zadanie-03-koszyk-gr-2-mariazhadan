package cart;

import model.Product;
import promo.Promotion;
import sort.ProductSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cart {

    private final List<Product> products = new ArrayList<>();
    private final List<Promotion> promotions = new ArrayList<>();
    private ProductSorter sorter;

    public void add(Product product) {
        if (product != null) products.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addPromotion(Promotion promotion) {
        if (promotion != null) promotions.add(promotion);
    }

    public void setSorter(ProductSorter sorter) {
        this.sorter = sorter;
    }

    public void sort() {
        if (sorter != null) sorter.sort(products);
    }

    public List<Product> applyPromotions() {
        List<Product> current = new ArrayList<>(products);

        for (Promotion p : promotions) {
            if (p != null) {
                current = p.apply(current);
            }
        }

        return current;
    }

    public double totalPrice(List<Product> list) {
        if (list == null) return 0;

        double sum = 0;
        for (Product p : list) {
            if (p != null) sum += p.getPrice();
        }
        return sum;
    }

    public Product findCheapest() {
        return products.stream()
                .filter(p -> p != null)
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }

    public Product findMostExpensive() {
        return products.stream()
                .filter(p -> p != null)
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }

    public List<Product> nCheapest(int n) {
        return products.stream()
                .filter(p -> p != null)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .limit(Math.max(0, n))
                .map(this::copyProduct)
                .toList();
    }

    public List<Product> nMostExpensive(int n) {
        return products.stream()
                .filter(p -> p != null)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(Math.max(0, n))
                .map(this::copyProduct)
                .toList();
    }

    private List<Product> copyList(List<Product> input) {
        List<Product> out = new ArrayList<>();
        if (input == null) return out;

        for (Product p : input) {
            if (p != null) out.add(copyProduct(p));
        }
        return out;
    }

    private Product copyProduct(Product p) {
        return new Product(p.getCode(), p.getName(), p.getPrice());
    }
}