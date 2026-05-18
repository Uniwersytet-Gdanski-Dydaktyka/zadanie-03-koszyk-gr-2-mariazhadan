package model;

public final class Product {
    private final String code;
    private final String name;
    private final double price;
    private final double discountPrice;

    public Product(String code, String name, double price, double discountPrice ) {
        if (code == null || name == null || price < 0) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public Product(String code, String name, double price) {
        this(code, name, price, 0);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

}