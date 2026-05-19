package promo;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PromotionTest {

        @Test
        void discountOver300() {
                Promotion p = new DiscountOver300();

                List<Product> in = List.of(
                        new Product("1", "A", 200),
                        new Product("2", "B", 200)
                );

                double sum = 0;
                for (Product pr : p.apply(in)) sum += pr.getPrice();

                assertEquals(380, sum, 0.01);
        }

        @Test
        void buy2get1() {
                Promotion p = new Buy2Get1Free();

                List<Product> in = List.of(
                        new Product("1", "A", 100),
                        new Product("2", "B", 80),
                        new Product("3", "C", 60)
                );

                boolean hasFree = p.apply(in).stream()
                        .anyMatch(x -> x.getPrice() == 0);

                assertTrue(hasFree);
        }

        @Test
        void coupon30() {
                Promotion p = new Coupon30Percent("2");

                List<Product> in = List.of(
                        new Product("1", "A", 100),
                        new Product("2", "B", 200)
                );

                double price = p.apply(in).stream()
                        .filter(x -> x.getCode().equals("2"))
                        .findFirst().get().getPrice();

                assertEquals(140, price, 0.01);
        }

        @Test
        void freeCup() {
                Promotion p = new FreeCup();

                List<Product> in = List.of(
                        new Product("1", "A", 150),
                        new Product("2", "B", 100)
                );

                boolean cup = p.apply(in).stream()
                        .anyMatch(x -> x.getCode().equals("CUP"));

                assertTrue(cup);
        }
        @Test
        void emptyList() {
                Promotion p = new DiscountOver300();

                List<Product> in = List.of();

                List<Product> out = p.apply(in);

                assertNotNull(out);
                assertTrue(out.isEmpty());
        }

        @Test
        void nullInsideList() {
                Promotion p = new Buy2Get1Free();

                List<Product> in = Arrays.asList(
                        new Product("1", "A", 100),
                        null,
                        new Product("2", "B", 80)
                );

                List<Product> out = p.apply(in);

                assertNotNull(out);
                assertFalse(out.stream().anyMatch(p1 -> p1 == null));
        }

        @Test
        void boundary300Exact() {
                Promotion p = new DiscountOver300();

                List<Product> in = List.of(
                        new Product("1", "A", 150),
                        new Product("2", "B", 150)
                );

                double sum = p.apply(in).stream()
                        .mapToDouble(Product::getPrice)
                        .sum();

                assertEquals(300, sum, 0.01);
                }
}
