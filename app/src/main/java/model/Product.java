package model;

public final class Product {
    private final String code;
    private final String name;
    private final double price;
    private double discountPrice;

    public Product(String code, String name, double price) {
        if (code == null || name == null || price < 0) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.name = name;
        this.price = price;
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

    public void setDiscountPrice(double discountPrice) {
        if (discountPrice < 0) {
            throw new IllegalArgumentException();
        }
        this.discountPrice = discountPrice;
    }

}