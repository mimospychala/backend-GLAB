package ch.bbcag.backend.product;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Product insert(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product changingProduct, Integer id) {
        Product existingProduct = this.findById(id);
        changingProduct.setId(id);
        return productRepository.save(changingProduct);
    }

    public void deleteById(Integer id) {
        findById(id); // throw exception if not found
        productRepository.deleteById(id);
    }
}
