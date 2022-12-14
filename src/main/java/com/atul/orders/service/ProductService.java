package com.atul.orders.service;

import com.atul.orders.model.Product;
import com.atul.orders.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.getAllProducts();
    }

    public String getSummary() {
        return repository.orderSummary();
    }

    public Product getProductById(int id) {
        return repository.findById(id);
    }

    public String deleteProduct(int id) {
        repository.delete(id);
        return "product not available! " + id;
    }

    public Product updateProduct(Product product) {
        return repository.update(product);
    }
}
