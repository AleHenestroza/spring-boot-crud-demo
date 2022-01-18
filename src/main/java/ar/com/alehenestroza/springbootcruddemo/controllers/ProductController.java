package ar.com.alehenestroza.springbootcruddemo.controllers;

import ar.com.alehenestroza.springbootcruddemo.entities.Product;
import ar.com.alehenestroza.springbootcruddemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/products")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/name/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}

