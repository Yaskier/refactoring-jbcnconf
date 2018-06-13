package pl.refactoring.interpreter;

public class AbovePriceSpec implements Spec{
    private float price;

    public AbovePriceSpec(float price) {
        this.price = price;
    }

    public boolean isSatisfiedBy(Product product) {
        return product.getPrice() > price;
    }
}
