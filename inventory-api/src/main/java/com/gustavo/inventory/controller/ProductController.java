package com.gustavo.inventory.controller;

import com.gustavo.inventory.model.Product;
import com.gustavo.inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepo;
    private final EmailService emailService;

    public ProductController(ProductRepository productRepo, EmailService emailService) {
        this.productRepo = productRepo;
        this.emailService = emailService;
    }

    public ProductController(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        Product savedProduct = productRepo.save(product);
        checkStock(savedProduct);
        return savedProduct;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setQuantity(productDetails.getQuantity());
        product.setMinStock(productDetails.getMinStock());

        Product updatedProduct = productRepo.save(product);
        checkStock(updatedProduct);
        return updatedProduct;
    }

    private void checkStock(Product product) {
        if (product.getQuantity() <= product.getMinStock()) {
            emailService.sendLowStockAlert(product.getName(), product.getQuantity());
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "Product deleted";
    }
}
