package pl.refactoring.interpreter.spec;

import pl.refactoring.interpreter.Product;
import pl.refactoring.interpreter.Spec;

public class AndSpec implements Spec {
    private final Spec left;
    private final Spec right;

    public AndSpec(Spec left, Spec right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return left.isSatisfiedBy(product) && right.isSatisfiedBy(product);
    }
}
