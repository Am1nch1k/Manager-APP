package ag.selm.manager.repository;

import ag.selm.manager.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> products = Collections.synchronizedList(new ArrayList<>());
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == 0) {
            product.setId(idGenerator.getAndIncrement());
            products.add(product);
        } else {
            products.replaceAll(p -> p.getId() == product.getId() ? product : p);
        }
        return product;
    }

    @Override
    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    @Override
    public void deleteById(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}