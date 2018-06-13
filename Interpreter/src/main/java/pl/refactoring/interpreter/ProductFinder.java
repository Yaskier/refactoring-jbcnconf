package pl.refactoring.interpreter;

import pl.refactoring.interpreter.spec.AndSpec;
import pl.refactoring.interpreter.spec.BelowPriceSpec;
import pl.refactoring.interpreter.spec.ColorSpec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class will be re-vamped by introducing Interpreter Design Pattern
 */
public class ProductFinder {
    private List<Product> repository;

    public ProductFinder(List<Product> repository) {
        this.repository = repository;
    }

    public List<Product> bySpec(Spec spec) {
        return repository.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    @Deprecated
    public List<Product> byColor(ProductColor color) {
        return bySpec(new ColorSpec(color));
    }

    @Deprecated
    public List<Product> byColorAndBelowPrice(ProductColor color, float price) {
        return bySpec(new AndSpec(new BelowPriceSpec(price), new ColorSpec(color)));
    }

    @Deprecated
    public List<Product> belowPriceAvoidingAColor(float price, ProductColor color) {
        return bySpec(new AndSpec(new BelowPriceSpec(price), new NotSpec(new ColorSpec(color))));
    }

    @Deprecated
    public List<Product> byColorAndAbovePrice(ProductColor color, float price) {
        return bySpec(new AndSpec(new AbovePriceSpec(price), new ColorSpec(color)));
    }

    public List<Product> byColorSizeAndBelowPrice(ProductColor color, ProductSize size, float price) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (product.getPrice() < price &&
                    product.size.equals(size) &&
                    product.getColor().equals(color))
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public List<Product> byPrice(float price) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (product.getPrice() == price) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
}
