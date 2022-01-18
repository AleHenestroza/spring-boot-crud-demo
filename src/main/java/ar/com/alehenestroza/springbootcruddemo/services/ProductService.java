package ar.com.alehenestroza.springbootcruddemo.services;

import ar.com.alehenestroza.springbootcruddemo.entities.Product;
import ar.com.alehenestroza.springbootcruddemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product " + id + " deleted";
    }

    public Product updateProduct(Product product) {
        Product productToUpdate = productRepository.findById(product.getId()).orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setQuantity(product.getQuantity());
            productToUpdate.setPrice(product.getPrice());
            return productRepository.save(productToUpdate);
        }
        return null;
    }
}
