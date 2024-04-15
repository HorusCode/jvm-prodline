package factory;

import core.Product;

public interface ProductFactory {
    Product createProduct(String name);
}
