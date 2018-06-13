package pl.refactoring.interpreter;

public class NotSpec implements  Spec{
    private Spec spec;

    public NotSpec(Spec spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return !spec.isSatisfiedBy(product);
    }
}
