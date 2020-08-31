package components;

public enum Type {
    STEEL(400),
    ALUMINUM(300),
    TITANIUM(600),
    CARBON_FIBER(1000),
    ;
    double price;

    Type(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
