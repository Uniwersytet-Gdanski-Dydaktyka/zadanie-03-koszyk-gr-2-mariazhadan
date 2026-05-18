package sort;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @Test
    void sortByPriceDesc() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("1", "A", 50));
        list.add(new Product("2", "B", 100));

        new SortByPriceDesc().sort(list);

        assertEquals(100, list.get(0).getPrice());
    }

    @Test
    void sortByNameAsc() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("1", "Z", 50));
        list.add(new Product("2", "A", 100));

        new SortByNameAsc().sort(list);

        assertEquals("A", list.get(0).getName());
    }

    @Test
    void sortByPriceThenName() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("1", "B", 100));
        list.add(new Product("2", "A", 100));

        new SortByPriceThenName().sort(list);

        assertEquals("A", list.get(0).getName());
    }
}