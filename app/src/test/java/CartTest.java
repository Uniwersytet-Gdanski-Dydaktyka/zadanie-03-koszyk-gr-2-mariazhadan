package cart;

import model.Product;
import org.junit.jupiter.api.Test;
import promo.*;
import sort.SortByPriceDesc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
    
public class CartTest {

    @Test
    void emptyCart_shouldReturnZero() {
        Cart cart = new Cart();

        double sum = cart.totalPrice(cart.getProducts());

        assertEquals(0, sum, 0.0001);
    }

    @Test
    void emptyCart_applyPromotion_shouldNotFail() {
        Cart cart = new Cart();
        cart.addPromotion(new DiscountOver300());

        List<Product> result = cart.applyPromotions();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void productWithZeroPrice_shouldBeAllowed() {
        Cart cart = new Cart();

        cart.add(new Product("1", "Free item", 0));

        assertEquals(1, cart.getProducts().size());
        assertEquals(0, cart.totalPrice(cart.getProducts()), 0.0001);
    }

    @Test
    void nullProduct_shouldBeIgnored() {
        Cart cart = new Cart();

        cart.add(null);

        assertEquals(0, cart.getProducts().size());
    }

    @Test
    void nullInPromotionList_shouldNotCrash() {
        Cart cart = new Cart();

        cart.add(new Product("1", "A", 100));

        cart.addPromotion(null);
        cart.addPromotion(new DiscountOver300());

        assertDoesNotThrow(cart::applyPromotions);
    }

    @Test
    void negativeN_shouldReturnEmptyList() {
        Cart cart = new Cart();

        cart.add(new Product("1", "A", 100));

        assertEquals(0, cart.nCheapest(-5).size());
        assertEquals(0, cart.nMostExpensive(-5).size());
    }

    @Test
    void zeroPrice_productsShouldNotBreakPromotions() {
        Cart cart = new Cart();

        cart.add(new Product("1", "A", 0));
        cart.add(new Product("2", "B", 0));

        cart.addPromotion(new DiscountOver300());

        assertDoesNotThrow(cart::applyPromotions);
    }

    @Test
    void addAndGet() {
        Cart cart = new Cart();
        cart.add(new Product("1", "A", 100));

        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void sortWorks() {
        Cart cart = new Cart();
        cart.add(new Product("1", "A", 50));
        cart.add(new Product("2", "B", 100));

        cart.setSorter(new SortByPriceDesc());
        cart.sort();

        assertEquals(100, cart.getProducts().get(0).getPrice());
    }

    @Test
    void cheapestAndMostExpensive() {
        Cart cart = new Cart();
        cart.add(new Product("1", "A", 50));
        cart.add(new Product("2", "B", 200));

        assertEquals(50, cart.findCheapest().getPrice());
        assertEquals(200, cart.findMostExpensive().getPrice());
    }

    @Test
    void nCheapest() {
        Cart cart = new Cart();
        cart.add(new Product("1", "A", 50));
        cart.add(new Product("2", "B", 100));
        cart.add(new Product("3", "C", 150));

        assertEquals(2, cart.nCheapest(2).size());
    }
}