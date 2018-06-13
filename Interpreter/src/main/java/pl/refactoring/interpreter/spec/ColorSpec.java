package pl.refactoring.interpreter.spec;

import pl.refactoring.interpreter.Product;
import pl.refactoring.interpreter.ProductColor;
import pl.refactoring.interpreter.Spec;

public class ColorSpec implements Spec {
    private ProductColor color;

    public ColorSpec(ProductColor color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getColor().equals(color);
    }
}
